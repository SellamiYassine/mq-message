import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Partenaire {
id?: number;
alias?: string | null;
type?: string | null;
direction?: string | null;
application?: string | null;
processedFlowType?: string | null;
description?: string | null;
}

@Injectable({
providedIn: 'root'
})
export class PartenaireService {
private apiUrl = 'http://localhost:8080/api/partenaires';

constructor(private http: HttpClient) { }

  getPartenaires(): Observable<Partenaire[]> {
    return this.http.get<Partenaire[]>(this.apiUrl);
  }

  addPartenaire(partenaire: Partenaire): Observable<Partenaire> {
    return this.http.post<Partenaire>(this.apiUrl, partenaire);
  }

  deletePartenaire(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
