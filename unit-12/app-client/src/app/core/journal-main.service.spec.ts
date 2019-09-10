import { TestBed } from '@angular/core/testing';

import { JournalMainService } from './journal-main.service';

describe('JournalMainService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JournalMainService = TestBed.get(JournalMainService);
    expect(service).toBeTruthy();
  });
});
