import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {
  MatButtonModule,
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

@NgModule({
  declarations: [
    AppComponent,
    QuestionJournalComponent,
    QuestionJournalDialogComponent,
    JournalComponent,
    SessionJournalComponent,
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
  ],
  entryComponents: [QuestionJournalDialogComponent],
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
