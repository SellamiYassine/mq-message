import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Message } from '../../core/services/message.service';

@Component({
selector: 'app-message-detail-dialog',
templateUrl: './message-detail-dialog.component.html'
})
export class MessageDetailDialogComponent {
constructor(@Inject(MAT_DIALOG_DATA) public data: Message) { }
}
