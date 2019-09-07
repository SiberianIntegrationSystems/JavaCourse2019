import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {QuestionJournalItemAnswer} from '../../../../model/question-journal-item-answer.model';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-answers-list',
  templateUrl: './answers-list.component.html',
  styleUrls: ['./answers-list.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AnswersListComponent implements OnInit, OnDestroy {

  @Input()
  list: QuestionJournalItemAnswer[];

  public dialogForm: FormGroup;

  @Output()
  invalidItem = new EventEmitter<boolean>();

  @Output()
  removed = new EventEmitter<void>();

  private subscription: Subscription;


  constructor(private fb: FormBuilder) {
  }

  ngOnInit() {
    this.dialogForm = this.fb.group({
      answerText: new FormControl('', Validators.required)
    });

    this.subscription = this.dialogForm.statusChanges.subscribe(status => this.invalidItem.emit(status === 'INVALID'));
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  public removeItem(item: QuestionJournalItemAnswer) {
    this.list = this.list.filter(val => val !== item);
    this.invalidItem.emit(this.list.length <= 0);
  }

  public addAnswer() {
    this.list.push({answerText: '', isCorrect: false});
    this.invalidItem.emit(true);
  }

}
