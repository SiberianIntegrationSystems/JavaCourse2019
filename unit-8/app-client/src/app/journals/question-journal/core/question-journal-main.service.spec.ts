import { TestBed } from '@angular/core/testing';

import { QuestionJournalMainService } from './question-journal-main.service';

describe('QuestionJournalMainService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: QuestionJournalMainService = TestBed.get(QuestionJournalMainService);
    expect(service).toBeTruthy();
  });
});
