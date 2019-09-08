import {ChangeDetectionStrategy, Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {QuestionJournalItem} from 'src/app/model/question-journal-item.model';
import {QuestionJournalItemAnswer} from '../../../model/question-journal-item-answer.model';

export interface JournalData {
  journalItem: QuestionJournalItem;
  eventLabel: string;
}

export interface QuestionJournalDialogResult {
  name: string;
  answers: QuestionJournalItemAnswer[];
}

export function validateIsCorrectControl(formArray: FormArray) {
  const formGroups: FormGroup[] = formArray.controls as FormGroup[];
  const res = formGroups
    .map(group => group.controls)
    .filter(control => control.isCorrect.value);

  if (res.length < 1) {
    return {
      validateEmail: {
        valid: false
      }
    };
  }
  return null;
}


@Component({
  selector: 'app-question-journal-dialog',
  templateUrl: './question-journal-dialog.component.html',
  styleUrls: ['./question-journal-dialog.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})


export class QuestionJournalDialogComponent implements OnInit {

  public eventLabel: string;
  public dialogForm: FormGroup;
  public answersFormArray: FormArray;

  private description: string;
  private answers: QuestionJournalItemAnswer[] = [];

  private static createAnswerFormGroup(answerText: string, isCorrect: boolean) {
    return new FormGroup({
        answerText: new FormControl(answerText, Validators.required),
        isCorrect: new FormControl(isCorrect)
      }
    );
  }

  constructor(public dialogRef: MatDialogRef<QuestionJournalDialogComponent>,
              private fb: FormBuilder,
              @Inject(MAT_DIALOG_DATA) public data: JournalData) {
  }

  ngOnInit() {
    this.fillData();
    this.fillForm();
  }

  private fillData() {
    this.eventLabel = this.data.eventLabel;
    if (this.data.journalItem) {
      this.description = this.data.journalItem.name;
      this.answers = this.data.journalItem.answers;
    }
  }

  private fillForm() {
    const answersArr: FormGroup[] = this.answers.map(ans =>
      QuestionJournalDialogComponent.createAnswerFormGroup(ans.answerText, ans.isCorrect)
    );

    this.dialogForm = this.fb.group({
      description: new FormControl(this.description, Validators.required),
      answersArray: this.fb.array(answersArr, [Validators.required, validateIsCorrectControl]),
    });

    this.answersFormArray = this.dialogForm.get('answersArray') as FormArray;
  }

  addAnswer() {
    this.answersFormArray.push(QuestionJournalDialogComponent.createAnswerFormGroup('', false));
  }

  removeItem(index: number) {
    this.answersFormArray.removeAt(index);
  }

  onDialogSubmit() {
    const newValues: QuestionJournalDialogResult = {
      name: this.dialogForm.get('description').value,
      answers: this.answersFormArray.value,
    };

    this.dialogRef.close(newValues);
  }

  closeDialog() {
    this.dialogRef.close();
  }

}
