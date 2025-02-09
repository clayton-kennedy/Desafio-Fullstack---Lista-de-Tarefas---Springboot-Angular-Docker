import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TarefaServiceService {
  private apiURL = 'http://localhost:8085';

  constructor(private http: HttpClient) {}

  listar(): Observable<any[]> {
    return this.http.get<any[]>(this.apiURL);
  }

  adicionar(tarefa: any): Observable<any> {
    return this.http.post<any>(this.apiURL, tarefa);
  }

  deletar(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiURL}/${id}`);
  }

  atualizar(tarefa: any): Observable<any> {
    return this.http.put<any>(`${this.apiURL}/${tarefa.id}`, tarefa);
  }
}