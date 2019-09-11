import {Injectable} from '@angular/core';
import {QuestionJournalItem} from 'src/app/model/question-journal-item.model';
import {QuestionJournalBackendMockService} from 'src/app/journals/question-journal/core/question-journal-backend-mock.service';
import {JournalMainService} from 'src/app/core/journal-main.service';
import {QuestionJournalDialogResult} from 'src/app/journals/question-journal/question-journal-dialog/question-journal-dialog.component';

export const QUESTIONS_JOURNAL_ID = 'questions';

@Injectable()
export class QuestionJournalMainService {

  constructor(private questionJournalBackend: QuestionJournalBackendMockService,
              private journalService: JournalMainService) {
  }

  public createJournalItem(newItem: QuestionJournalDialogResult) {
    this.questionJournalBackend.createJournalItem(newItem)
      .toPromise()
      .then(() => {
        this.journalService.refreshJournal();
      });
  }

  public editJournalItem(item: QuestionJournalItem) {
    this.questionJournalBackend.editQuestionJournalItem(item)
      .toPromise()
      .then(() => {
        this.journalService.refreshJournal();
      });
  }
}
