import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Message {
id: number;
message: string;
receivedDateTime: string;
}

@Injectable({
providedIn: 'root'
})
export class MessageService {
private apiUrl = '/api/messages';

constructor(private http: HttpClient) { }

  getMessages(): Observable<Message[]> {
    return this.http.get<Message[]>('http://localhost:8080/api/messages');
  }

  getMessage(id: number): Observable<Message> {
    return this.http.get<Message>(`${this.apiUrl}/${id}`);
  }
}
