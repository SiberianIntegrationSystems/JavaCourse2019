import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionJournalComponent } from 'src/app/question/question-journal/question-journal.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: QuestionJournalComponent,
  },
];

@NgModule({
            imports: [RouterModule.forRoot(routes)],
            exports: [RouterModule],
          })
export class AppRoutingModule {
}
