import {ChangeDetectionStrategy, Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subscription} from "rxjs";
import {FormControl} from "@angular/forms";
import {JournalMainService} from "../../core/journal-main.service";
import {PageEvent} from "@angular/material/paginator";
import {debounceTime, map, startWith, tap} from "rxjs/operators";
import {SESSIONS_JOURNAL_ID} from "./main/session-journal-main.service";
import {SessionJournalItem} from "../../model/session/session-journal-item.model";

@Component({
  selector: 'app-session-journal',
  templateUrl: './session-journal.component.html',
  styleUrls: ['./session-journal.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class SessionJournalComponent implements OnInit, OnDestroy {

  public readonly journalId = SESSIONS_JOURNAL_ID;
  public searchFormControl = new FormControl();

  public displayedColumns: string[] = [
    'id',
    'insertDate',
    'name',
    'result',
  ];

  public sessions$: Observable<SessionJournalItem[]>;
  public length$: Observable<number>;
  public pageSize$: Observable<number>;

  private lastPageSize: number;
  private searchSubscription: Subscription;

  constructor(private service: JournalMainService) {
  }

  ngOnInit() {
    this.fillJournalData();
    this.fillSearchFormControl();
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

  private fillJournalData() {
    const result$ = this.service.getResult();
    this.sessions$ = result$.pipe(map(result => result.items as SessionJournalItem[]));
    this.length$ = result$.pipe(map(result => result.total));

    this.pageSize$ = this.service.getPageSize().pipe(
      tap(pageSize => this.lastPageSize = pageSize),
    );
  }

  private fillSearchFormControl() {
    this.searchSubscription = this.searchFormControl.valueChanges.pipe(
      startWith(''),
      debounceTime(300),
    ).subscribe(search => this.service.setSearch(search));
  }

}
