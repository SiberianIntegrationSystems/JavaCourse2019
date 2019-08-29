import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JournalEntity } from 'src/app/model/core/journal-entity.model';
import { JournalRequest } from 'src/app/model/core/journal-request.model';
import { JournalResult } from 'src/app/model/core/journal-result.model';

export const QUESTIONS_JOURNAL_ID = 'questions';

@Injectable()
export class JournalBackendMockService {

  constructor(private http:HttpClient) {
  }

  getJournalInfo(id: string): Observable<JournalEntity> {
    return this.http.get<JournalEntity>(this.getRestUrl() + id);
  }

  getResult(request: JournalRequest): Observable<JournalResult> {
    return this.http.put<JournalResult>(this.getRestUrl() + request.journalId + '/rows', request);
  }

  private getRestUrl(): string {
    return 'http://localhost:8080/api/journal/';
  }
}
