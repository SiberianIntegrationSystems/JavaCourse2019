import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable, Subscription} from "rxjs";
import {SessionJournalMainService} from "../main/session-journal-main.service";
import {QuestionJournalItem} from "../../../model/question-journal-item.model";
import {SessionResultDialogComponent} from "../session-result-dialog/session-result-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-session',
  templateUrl: './new-session.component.html',
  styleUrls: ['./new-session.component.css']
})
export class NewSessionComponent implements OnInit, OnDestroy {

  public questions$: Observable<QuestionJournalItem[]>;

  public sessionForm: FormGroup;
  public questionGroups: FormArray;

  private formSubscription: Subscription;

  constructor(private service: SessionJournalMainService,
              private fb: FormBuilder,
              private dialog: MatDialog,
              private router: Router) { }

  ngOnInit() {
    this.sessionForm = this.fb.group({
      name: this.fb.control('', Validators.required),
      questionsList: this.fb.array([]),
    });
    this.fillQuestions();
  }

  ngOnDestroy(): void {
    this.formSubscription.unsubscribe();
  }

  public onSessionSubmit() {
    this.service.submitNewSession(this.sessionForm.value)
      .toPromise()
      .then(result => this.openResultDialog(result));
  }

  private fillQuestions() {
    this.questions$ = this.service.getQuestionsForNewSession();
    this.formSubscription = this.questions$.subscribe(questions => this.fillFormGroups(questions));
  }

  private fillFormGroups(questions: QuestionJournalItem[]) {
    this.questionGroups = this.fb.array(questions.map(question => this.fb.group({
      id: question.id,
      answersList: this.fb.array(question.answers.map(answer => this.fb.group({
        id: answer.id,
        isSelected: this.fb.control(false)
      })))
    })));

    this.sessionForm = this.fb.group({
      name: this.fb.control('', Validators.required),
      questionsList: this.questionGroups,
    });
  }

  private openResultDialog(result: string) {
    const dialogRef = this.dialog.open(SessionResultDialogComponent, {
      width: '350px',
      data: result,
      restoreFocus: false,
      disableClose: true,
    });

    return dialogRef.afterClosed()
      .toPromise()
      .then(() => this.router.navigate(['sessions']));
  }
}
