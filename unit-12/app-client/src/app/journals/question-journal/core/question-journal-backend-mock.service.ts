import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BASE_URL} from 'src/app/core/journal-backend-mock.service';
import {QuestionJournalItem} from 'src/app/model/question-journal-item.model';
import {QuestionJournalDialogResult} from 'src/app/journals/question-journal/question-journal-dialog/question-journal-dialog.component';
import {Observable} from 'rxjs';

@Injectable()
export class QuestionJournalBackendMockService {

  private static getQuestionJournalRestUrl(): string {
    return BASE_URL + 'question/';
  }

  constructor(private http: HttpClient) {
  }

  editQuestionJournalItem(item: QuestionJournalItem): Observable<QuestionJournalItem> {
    return this.http.put<QuestionJournalItem>(
      QuestionJournalBackendMockService.getQuestionJournalRestUrl() + 'edit', item
    );
  }

  createJournalItem(newItem: QuestionJournalDialogResult): Observable<QuestionJournalItem> {
    return this.http.post<QuestionJournalItem>(
      QuestionJournalBackendMockService.getQuestionJournalRestUrl() + 'create', newItem
    );
  }

}
