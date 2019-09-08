import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionJournalComponent } from 'src/app/journals/question-journal/question-journal.component';
import {SessionJournalComponent} from "./journals/session-journal/session-journal.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'questions',
    pathMatch: 'full'
  }, {
    path: 'questions',
    component: QuestionJournalComponent,
    pathMatch: 'full',
  }, {
    path: 'sessions',
    component: SessionJournalComponent,
    pathMatch: 'full',
  },
];

@NgModule({
            imports: [RouterModule.forRoot(routes)],
            exports: [RouterModule],
          })
export class AppRoutingModule {
}
