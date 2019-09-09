import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatDialogModule,
  MatDividerModule,
  MatIconModule,
  MatInputModule,
  MatPaginatorModule,
  MatSelectModule,
  MatSortModule,
  MatTableModule,
} from '@angular/material';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {JournalBackendMockService} from './core/journal-backend-mock.service';
import {JournalComponent} from './journals/journal.component';
import {QuestionJournalDialogComponent} from './journals/question-journal/question-journal-dialog/question-journal-dialog.component';
import {QuestionJournalComponent} from './journals/question-journal/question-journal.component';
import {JournalMainService} from './core/journal-main.service';
import {QuestionJournalMainService} from './journals/question-journal/core/question-journal-main.service';
import {QuestionJournalBackendMockService} from './journals/question-journal/core/question-journal-backend-mock.service';
import {MatTabsModule} from "@angular/material/tabs";
import { SessionJournalComponent } from './journals/session-journal/session-journal.component';
import {SessionJournalMainService} from "./journals/session-journal/main/session-journal-main.service";
import { NewSessionComponent } from './journals/session-journal/new-session/new-session.component';
import { SessionResultDialogComponent } from './journals/session-journal/session-result-dialog/session-result-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    QuestionJournalComponent,
    QuestionJournalDialogComponent,
    JournalComponent,
    SessionJournalComponent,
    NewSessionComponent,
    SessionResultDialogComponent,
  ],
  imports: [
    BrowserAnimationsModule,
    HttpClientModule,
    MatDividerModule,
    MatTableModule,
    MatButtonModule,
    MatPaginatorModule,
    MatSortModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatDialogModule,
    MatCheckboxModule,
    MatIconModule,
    MatTabsModule,
    MatCardModule,
  ],
  entryComponents: [
    QuestionJournalDialogComponent,
    SessionResultDialogComponent,
  ],
  providers: [
    JournalBackendMockService,
    JournalMainService,
    QuestionJournalMainService,
    QuestionJournalBackendMockService,
    SessionJournalMainService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
