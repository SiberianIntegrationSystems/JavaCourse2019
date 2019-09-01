import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionJournalComponent } from 'src/app/question/question-journal/question-journal.component';

describe('QuestionJournalComponent', () => {
  let component: QuestionJournalComponent;
  let fixture: ComponentFixture<QuestionJournalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
                                     declarations: [QuestionJournalComponent],
                                   })
           .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestionJournalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
