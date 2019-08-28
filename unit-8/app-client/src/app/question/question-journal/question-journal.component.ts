import { ChangeDetectionStrategy, Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { PageEvent } from '@angular/material';
import { Observable, Subscription } from 'rxjs';
import { debounceTime, map, startWith, tap } from 'rxjs/operators';
import { QUESTIONS_JOURNAL_ID } from 'src/app/core/journal-backend-mock.service';
import { JournalMainService } from 'src/app/core/journal-main.service';
import {
  FILTER_CODE_QUESTION_ANSWERS_COUNT,
  FILTER_TYPE_SINGLE_SELECT,
  JournalFilterItem,
} from 'src/app/model/core/journal-filter-item';
import { QuestionJournalItem } from 'src/app/model/question-journal-item.model';

@Component({
             selector: 'app-task-journal',
             templateUrl: './question-journal.component.html',
             styleUrls: ['./question-journal.component.css'],
             providers: [JournalMainService],
             changeDetection: ChangeDetectionStrategy.OnPush,
           })
export class QuestionJournalComponent implements OnInit, OnDestroy {

  displayedColumns: string[] = [
    'id',
    'name',
    'answersCount',
  ];

  questions$: Observable<QuestionJournalItem[]>;
  journalName$: Observable<string>;

  length$: Observable<number>;
  pageSize$: Observable<number>;

  answersCountItems = [1, 2, 3, 4];

  questionFiltersForm: FormGroup;
  searchFormControl = new FormControl();

  private lastPageSize: number;
  private searchSubscription: Subscription;

  private static convertFilters(formValue: any): JournalFilterItem[] {
    const filters: JournalFilterItem[] = [];

    if (formValue.hasOwnProperty('answersCount')) {
      filters.push({
                     type: FILTER_TYPE_SINGLE_SELECT,
                     code: FILTER_CODE_QUESTION_ANSWERS_COUNT,
                     value: formValue.answersCount,
                   });
    }

    return filters;
  }

  constructor(private service: JournalMainService, private fb: FormBuilder) {
  }

  ngOnInit() {
    this.fillJournalData();
    this.fillSearchFormControl();
    this.fillFiltersForm();
  }

  public ngOnDestroy(): void {
    this.searchSubscription.unsubscribe();
  }

  onPageClick(event: PageEvent) {
    if (event.pageSize !== this.lastPageSize) {
      this.service.setPageSize(event.pageSize);
    } else if (event.previousPageIndex !== event.pageIndex) {
      this.service.setPage(event.pageIndex + 1);
    }
  }

  refresh() {
    this.service.refreshJournal();
  }

  onFiltersSubmit() {
    this.service.setFilters(QuestionJournalComponent.convertFilters(this.questionFiltersForm.value));
  }

  private fillFiltersForm() {
    this.questionFiltersForm = this.fb.group({
                                               answersCount: ['', []],
                                             });
  }

  private fillSearchFormControl() {
    this.searchSubscription = this.searchFormControl.valueChanges.pipe(
      startWith(''),
      debounceTime(300),
    ).subscribe(search => this.service.setSearch(search));
  }

  private fillJournalData() {
    this.service.initJournal(QUESTIONS_JOURNAL_ID);

    const result$ = this.service.getResult();
    this.questions$ = result$.pipe(map(result => result.items as QuestionJournalItem[]));
    this.length$ = result$.pipe(map(result => result.total));

    const journalInfo$ = this.service.getJournalInfo();
    this.journalName$ = journalInfo$.pipe(map(info => info.name));
    this.pageSize$ = this.service.getPageSize().pipe(
      tap(pageSize => this.lastPageSize = pageSize),
    );
  }
}
