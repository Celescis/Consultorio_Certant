import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfesionalService {

  private apiUrl = 'http://localhost:8080/pro';

  constructor(private http: HttpClient) { }

  crear(profesional: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/post`, profesional, { responseType: 'text' as 'json' });
  }

}
