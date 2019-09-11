import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-session-result-dialog',
  templateUrl: './session-result-dialog.component.html',
  styleUrls: ['./session-result-dialog.component.css']
})
export class SessionResultDialogComponent {

  constructor(public dialogRef: MatDialogRef<SessionResultDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: string) { }

  onClick() {
    this.dialogRef.close();
  }

}
