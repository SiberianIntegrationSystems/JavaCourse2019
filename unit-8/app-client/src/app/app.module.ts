import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import {
  MatButtonModule,
  MatDividerModule,
  MatInputModule,
  MatPaginatorModule,
  MatSelectModule,
  MatSortModule,
  MatTableModule,
} from '@angular/material';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { QuestionJournalComponent } from 'src/app/question/question-journal/question-journal.component';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JournalBackendMockService } from './core/journal-backend-mock.service';

@NgModule({
            declarations: [
              AppComponent,
              QuestionJournalComponent,
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
            ],
            providers: [JournalBackendMockService],
            bootstrap: [AppComponent],
          })
export class AppModule {
}
