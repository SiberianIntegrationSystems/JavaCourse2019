import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JournalEntity } from 'src/app/model/core/journal-entity.model';
import { JournalRequest } from 'src/app/model/core/journal-request.model';
import { JournalResult } from 'src/app/model/core/journal-result.model';

export const BASE_URL = 'http://localhost:8080/api/';

@Injectable()
export class JournalBackendMockService {

  private static getJournalRestUrl(): string {
    return BASE_URL + 'journal/';
  }

  constructor(private http: HttpClient) {
  }

  getJournalInfo(id: string): Observable<JournalEntity> {
    return this.http.get<JournalEntity>(JournalBackendMockService.getJournalRestUrl() + id);
  }

  getResult(request: JournalRequest): Observable<JournalResult> {
    return this.http.put<JournalResult>(JournalBackendMockService.getJournalRestUrl() + request.journalId + '/rows', request);
  }

}
