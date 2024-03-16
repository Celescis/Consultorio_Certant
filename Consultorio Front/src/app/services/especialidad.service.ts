import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EspecialidadService {
  private apiUrl = 'http://localhost:8080/esp';

  constructor(private http: HttpClient) { }

  obtenerEspecialidades(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}`);
  }

  crear(especialidad: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/post`, especialidad, { responseType: 'text' as 'json' });
  }
}
