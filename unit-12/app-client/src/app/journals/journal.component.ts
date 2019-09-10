import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {JournalMainService} from 'src/app/core/journal-main.service';

@Component({
  selector: 'app-journal',
  templateUrl: './journal.component.html',
  styleUrls: ['./journal.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class JournalComponent implements OnInit {

  @Input()
  journalId: string;

  journalName$: Observable<string>;

  constructor(private service: JournalMainService) {
  }

  ngOnInit() {
    this.service.initJournal(this.journalId);
    this.journalName$ = this.service.getJournalInfo()
      .pipe(
        map(info => info.name)
      );
  }

  refresh() {
    this.service.refreshJournal();
  }

}
