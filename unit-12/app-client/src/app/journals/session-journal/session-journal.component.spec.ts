import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionJournalComponent } from './session-journal.component';

describe('SessionJournalComponent', () => {
  let component: SessionJournalComponent;
  let fixture: ComponentFixture<SessionJournalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SessionJournalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SessionJournalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
