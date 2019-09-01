import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionJournalDialogComponent } from './question-journal-dialog.component';

describe('DialogBoxComponent', () => {
  let component: QuestionJournalDialogComponent;
  let fixture: ComponentFixture<QuestionJournalDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuestionJournalDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestionJournalDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
