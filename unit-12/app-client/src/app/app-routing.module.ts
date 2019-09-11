import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionJournalComponent } from 'src/app/journals/question-journal/question-journal.component';
import {SessionJournalComponent} from "./journals/session-journal/session-journal.component";
import {NewSessionComponent} from "./journals/session-journal/new-session/new-session.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'questions',
    pathMatch: 'full'
  }, {
    path: 'questions',
    component: QuestionJournalComponent,
  }, {
    path: 'sessions',
    component: SessionJournalComponent,
  }, {
    path: 'sessions/new',
    component: NewSessionComponent,
  },
];

@NgModule({
            imports: [RouterModule.forRoot(routes)],
            exports: [RouterModule],
          })
export class AppRoutingModule {
}
