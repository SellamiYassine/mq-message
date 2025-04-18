import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MessageService, Message } from '../../core/services/message.service';
import { MessageDetailDialogComponent } from './message-detail-dialog.component';
import { MatTableModule } from '@angular/material/table';

@Component({
imports: [
MatTableModule
],
selector: 'app-message-list',
templateUrl: './message-list.component.html',
standalone: true,
})
export class MessageListComponent implements OnInit {
messages: Message[] = [];
displayedColumns: string[] = ['id', 'message', 'receivedDateTime'];

constructor(private messageService: MessageService, private dialog: MatDialog, private table: MatTableModule) { }

  ngOnInit(): void {
    this.messageService.getMessages().subscribe((data) => {
      this.messages = data;
    });
  }

  openDetail(message: Message): void {
    this.dialog.open(MessageDetailDialogComponent, {
      data: message
    });
  }
}
