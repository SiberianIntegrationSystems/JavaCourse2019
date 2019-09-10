import {ChangeDetectionStrategy, Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {MatDialog, PageEvent} from '@angular/material';
import {Observable, Subscription} from 'rxjs';
import {debounceTime, map, startWith, tap} from 'rxjs/operators';
import {JournalMainService} from 'src/app/core/journal-main.service';
import {FILTER_CODE_QUESTION_ANSWERS_COUNT, FILTER_TYPE_SINGLE_SELECT, JournalFilterItem} from 'src/app/model/core/journal-filter-item';
import {QuestionJournalItem} from 'src/app/model/question-journal-item.model';
import {
  QuestionJournalDialogComponent,
  QuestionJournalDialogResult
} from 'src/app/journals/question-journal/question-journal-dialog/question-journal-dialog.component';
import {QuestionJournalMainService, QUESTIONS_JOURNAL_ID} from 'src/app/journals/question-journal/core/question-journal-main.service';

@Component({
  selector: 'app-question-journal',
  templateUrl: './question-journal.component.html',
  styleUrls: ['./question-journal.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class QuestionJournalComponent implements OnInit, OnDestroy {

  public readonly journalId = QUESTIONS_JOURNAL_ID;
  public readonly answersCountItems = [1, 2, 3, 4, 5];

  public displayedColumns: string[] = [
    'edit',
    'id',
    'name',
    'answersCount',
  ];

  public questions$: Observable<QuestionJournalItem[]>;
  public length$: Observable<number>;
  public pageSize$: Observable<number>;
  public questionFiltersForm: FormGroup;
  public searchFormControl = new FormControl();

  private lastPageSize: number;
  private searchSubscription: Subscription;

  private static convertDialogResultToJournalItem(itemId: string, data: QuestionJournalDialogResult): QuestionJournalItem {
    return {
      id: itemId,
      name: data.name,
      answers: data.answers,
    };
  }

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

  constructor(private service: JournalMainService,
              private fb: FormBuilder,
              private dialog: MatDialog,
              private questionJournalService: QuestionJournalMainService) {
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

  onFiltersSubmit() {
    this.service.setFilters(QuestionJournalComponent.convertFilters(this.questionFiltersForm.value));
  }

  createQuestion() {
    this.openDialog('Создать')
      .then((newItem: QuestionJournalDialogResult) => {
        if (newItem) {
          this.questionJournalService.createJournalItem(newItem);
        }
      });
  }

  editQuestion(item: QuestionJournalItem) {
    this.openDialog('Редактировать', item)
      .then((newValues: QuestionJournalDialogResult) => {
        if (newValues) {
          this.questionJournalService.editJournalItem(
            QuestionJournalComponent.convertDialogResultToJournalItem(item.id, newValues));
        }
      });
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

    const result$ = this.service.getResult();
    this.questions$ = result$.pipe(map(result => result.items as QuestionJournalItem[]));
    this.length$ = result$.pipe(map(result => result.total));

    this.pageSize$ = this.service.getPageSize().pipe(
      tap(pageSize => this.lastPageSize = pageSize),
    );
  }

  private openDialog(label: string, item?: QuestionJournalItem): Promise<QuestionJournalDialogResult> {
    const dialogRef = this.dialog.open(QuestionJournalDialogComponent, {
      width: '700px',
      data: {
        eventLabel: label,
        journalItem: item,
      },
      restoreFocus: false,
      disableClose: true,
    });

    return dialogRef.afterClosed().toPromise();
  }

}
