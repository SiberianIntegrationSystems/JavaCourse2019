import { TestBed } from '@angular/core/testing';

import { JournalBackendMockService } from './journal-backend-mock.service';

describe('JournalBackendMockService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JournalBackendMockService = TestBed.get(JournalBackendMockService);
    expect(service).toBeTruthy();
  });
});
