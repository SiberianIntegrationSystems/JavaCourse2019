import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {BASE_URL} from "../../../core/journal-backend-mock.service";
import {QuestionJournalItem} from "../../../model/question-journal-item.model";
import {NewSession} from "../../../model/session/new-session.model";

export const SESSIONS_JOURNAL_ID = 'sessions';

@Injectable()
export class SessionJournalMainService {

  constructor(private http: HttpClient) { }

  public getQuestionsForNewSession(): Observable<QuestionJournalItem[]> {
    return this.http.get<QuestionJournalItem[]>(this.getBaseUrl() + '/questions-new');
  }

  public submitNewSession(newSessionDTO: NewSession): Observable<string> {
    return this.http.post<string>(this.getBaseUrl(), newSessionDTO);
  }

  private getBaseUrl(): string {
    return BASE_URL + 'session';
  }
}
