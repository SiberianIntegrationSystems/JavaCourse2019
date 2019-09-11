import {Injectable} from '@angular/core';
import {BehaviorSubject, combineLatest, merge, Observable, ReplaySubject, Subject} from 'rxjs';
import {debounceTime, distinctUntilChanged, map, mapTo, shareReplay, startWith, switchMap, take} from 'rxjs/operators';
import {JournalEntity} from 'src/app/model/core/journal-entity.model';
import {JournalFilterItem} from 'src/app/model/core/journal-filter-item';
import {JournalRequest} from 'src/app/model/core/journal-request.model';
import {JournalResult} from 'src/app/model/core/journal-result.model';
import {JournalBackendMockService} from 'src/app/core/journal-backend-mock.service';

@Injectable()
export class JournalMainService {

  private readonly refresh$: Subject<void> = new BehaviorSubject(void 0);
  private readonly result$: Observable<JournalResult>;
  private readonly journalInfo$: Subject<JournalEntity> = new ReplaySubject(1);

  private readonly search$: Subject<string> = new BehaviorSubject('');
  private readonly page$: Subject<number> = new BehaviorSubject(1);
  private readonly pageSizeInput$: Subject<number> = new ReplaySubject(1);
  private readonly pageSize$: Observable<number>;
  private readonly filters$: Subject<JournalFilterItem[]> = new BehaviorSubject([]);

  private static formRequest(journal: JournalEntity, search: string, page: number, pageSize: number,
                             filters: JournalFilterItem[]): JournalRequest {
    return {
      journalId: journal.id,
      search,
      page,
      pageSize,
      filters,
    };
  }

  constructor(private backend: JournalBackendMockService) {
    const search$ = this.search$.asObservable().pipe(distinctUntilChanged());
    const journalInfo$ = this.journalInfo$.asObservable().pipe(distinctUntilChanged());

    this.pageSize$ = merge(
      this.pageSizeInput$, journalInfo$.pipe(map(info => info.defaultPageSize)),
    ).pipe(
      startWith(5),
      distinctUntilChanged(),
    );
    const filters$ = this.filters$.asObservable().pipe(distinctUntilChanged());
    const page$ = merge(
      search$.pipe(mapTo(1)),
      this.pageSize$.pipe(mapTo(1)),
      filters$.pipe(mapTo(1)),
      this.page$.asObservable().pipe(distinctUntilChanged()),
    );

    this.result$ = combineLatest(
      [journalInfo$, search$, page$, this.pageSize$, filters$, this.refresh$],
    ).pipe(
      map(([journalInfo, searchString, page, pageSize, filters]) =>
        JournalMainService.formRequest(journalInfo, searchString, page, pageSize, filters)),
      debounceTime(0),
      switchMap(request => this.backend.getResult(request)),
      shareReplay(1),
    );
  }

  initJournal(journalId: string) {
    this.backend.getJournalInfo(journalId)
      .pipe(take(1))
      .toPromise()
      .then(info => this.journalInfo$.next(info));
  }

  getResult(): Observable<JournalResult> {
    return this.result$;
  }

  getJournalInfo(): Observable<JournalEntity> {
    return this.journalInfo$.asObservable();
  }

  getPageSize() {
    return this.pageSize$;
  }

  setSearch(value: string) {
    this.search$.next(value);
  }

  setPage(value: number) {
    this.page$.next(value);
  }

  setPageSize(value: number) {
    this.pageSizeInput$.next(value);
  }

  setFilters(value: JournalFilterItem[]) {
    this.filters$.next(value);
  }

  refreshJournal() {
    this.refresh$.next();
  }
}
