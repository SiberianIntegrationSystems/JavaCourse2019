import {ChangeDetectionStrategy, Component, Inject, OnInit, ViewChild, ViewChildren} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {QuestionJournalItem} from 'src/app/model/question-journal-item.model';
import {QuestionJournalItemAnswer} from '../../../model/question-journal-item-answer.model';
import {AnswersListComponent} from '../components/answers-list/answers-list.component';

export interface JournalData {
  journalItem: QuestionJournalItem;
  eventLabel: string;
  answersCountItems: number[];
}

export interface QuestionJournalDialogResult {
  name: string;
  answersCount: number;
  answers: QuestionJournalItemAnswer[];
}

@Component({
  selector: 'app-question-journal-dialog',
  templateUrl: './question-journal-dialog.component.html',
  styleUrls: ['./question-journal-dialog.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})

export class QuestionJournalDialogComponent implements OnInit {

  @ViewChild(AnswersListComponent, {static: false})
  child: AnswersListComponent;

  public eventLabel: string;
  public answersCountItems: number[];
  public dialogForm: FormGroup;
  public answerForm: FormGroup;
  public isInvalidAnswers: boolean;
  public canCreate: boolean;

  public showErrorMessage: boolean;
  private description: string;
  private answersCount: number;
  private answers: QuestionJournalItemAnswer[] = [];

  constructor(public dialogRef: MatDialogRef<QuestionJournalDialogComponent>,
              private fb: FormBuilder,
              @Inject(MAT_DIALOG_DATA) public data: JournalData) {
  }

  ngOnInit() {
    this.fillData();
    this.fillForm();
  }

  addAnswer() {
    this.answers.push(
      {
        answerText: this.answerForm.get('answerText').value,
        isCorrect: this.answerForm.get('isCorrect').value
      }
    );
    this.clear();
  }

  private clear() {
    this.answerForm.get('answerText').setValue('');
    this.answerForm.get('isCorrect').setValue(false);
  }

  removeItem(item: QuestionJournalItemAnswer) {
    this.answers = this.answers.filter(val => val !== item);
  }

  public checkAnswers(isInvalid: boolean) {
    console.log(isInvalid);
    this.isInvalidAnswers = isInvalid;
  }

  public save(item: QuestionJournalItemAnswer) {
    this.answers = this.answers.filter(val => val === item);
    this.answers.push({
      answerText: this.answerForm.get('answerText').value,
      isCorrect: this.answerForm.get('isCorrect').value,
    });
  }

  private fillData() {
    this.eventLabel = this.data.eventLabel;
    this.answersCountItems = this.data.answersCountItems;

    if (this.data.journalItem) {
      this.description = this.data.journalItem.name;
      this.answersCount = this.data.journalItem.answersCount;
      this.answers = this.data.journalItem.answers;
    }
  }

  private fillForm() {
    this.dialogForm = this.fb.group({
      description: new FormControl(this.description, Validators.required),
      demoArray: this.fb.array([]),
    });

    // this.answerForm = this.fb.group({
    //   answerText: new FormControl('', Validators.required),
    //   isCorrect: new FormControl(),
    // });
  }


  onDialogSubmit() {
    console.log(this.answers);
    // this.answers = this.child.getList();
    const hasCorrect = this.answers.filter(answer => answer.isCorrect);
    // if (!hasCorrect) {
    //   this.showErrorMessage = true;
    // } else {
    //   const newValues: QuestionJournalDialogResult = {
    //     name: this.dialogForm.get('description').value,
    //     answersCount: this.dialogForm.get('answersCount').value,
    //     answers: [],
    //   };
    //
    //   this.dialogRef.close(newValues);
    // }

  }

  closeDialog() {
    this.dialogRef.close();
  }

}
