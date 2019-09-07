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

  // @ViewChild(AnswersListComponent)
  // child: AnswersListComponent;

  public eventLabel: string;
  public answersCountItems: number[];
  public dialogForm: FormGroup;
  public isInvalidAnswers: boolean;

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

  public checkAnswers(isInvalid: boolean) {
    console.log(isInvalid);
    this.isInvalidAnswers = isInvalid;
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
      // answersCount: new FormControl(this.answersCount, Validators.required),
      // answers: new FormControl(this.answers, Validators.required),
    });
  }


  onDialogSubmit() {
    const hasCorrect = this.answers.filter(answer => answer.isCorrect);
    console.log(this.answers);
    if (!hasCorrect) {
      this.showErrorMessage = true;
    } else {
      const newValues: QuestionJournalDialogResult = {
        name: this.dialogForm.get('description').value,
        answersCount: this.dialogForm.get('answersCount').value,
        answers: [],
      };

      this.dialogRef.close(newValues);
    }

  }

  closeDialog() {
    this.dialogRef.close();
  }

}
