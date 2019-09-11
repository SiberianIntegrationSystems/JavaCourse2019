import { TestBed } from '@angular/core/testing';

import { SessionJournalMainService } from './session-journal-main.service';

describe('SessionJournalMainService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SessionJournalMainService = TestBed.get(SessionJournalMainService);
    expect(service).toBeTruthy();
  });
});
