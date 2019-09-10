import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionResultDialogComponent } from './session-result-dialog.component';

describe('SessionResultDialogComponent', () => {
  let component: SessionResultDialogComponent;
  let fixture: ComponentFixture<SessionResultDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SessionResultDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SessionResultDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
