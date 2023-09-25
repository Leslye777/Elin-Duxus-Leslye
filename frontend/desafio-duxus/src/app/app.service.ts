import { HttpClientModule, HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  private baseUrl = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }

  inserirIntegrante(integrante: any): Observable<any> {
    return this.http.post<any>(this.baseUrl + 'cadastrar-integrante', integrante);
  }

  listarIntegrantes(): Observable<any> {
    return this.http.get<any>(this.baseUrl + 'integrantes', );
  }

  cadastrarComposicaoTime(idTime: number, idIntegrante: number): Observable<any> {
    const params = new HttpParams()
      .set('idTime', idTime.toString())
      .set('idIntegrante', idIntegrante.toString());

    return this.http.post<any>(this.baseUrl + 'cadastrar-composicao', {}, { params });
  }

}
