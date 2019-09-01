import { TestBed } from '@angular/core/testing';

import { QuestionJournalBackendMockService } from './question-journal-backend-mock.service';

describe('QuestionJournalBackendMockService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: QuestionJournalBackendMockService = TestBed.get(QuestionJournalBackendMockService);
    expect(service).toBeTruthy();
  });
});
