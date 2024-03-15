import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {
  private apiUrl = 'http://localhost:8080/pac';

  constructor(private http: HttpClient) { }

  crear(paciente: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/post`, paciente, { responseType: 'text' as 'json' });
  }

}
