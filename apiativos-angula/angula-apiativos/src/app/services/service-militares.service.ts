
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Militar } from '../models/militar';



@Injectable({
  providedIn: 'root'
})
export class ServiceMilitaresService {

  url = 'http://localhost:8080/api/';


  constructor(private httpClient: HttpClient) { }

  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }


  // Obtem todos os carros
  getMilitarAll(): Observable<Militar[]> {
    return this.httpClient.get<Militar[]>(this.url + 'militarAtivo')
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  getCarByNome(nome: string, efetivo: string): Observable<Militar[]> {
    return this.httpClient.get<Militar[]>(this.url + '/militarNomeEfetivo/' + nome + '/' + efetivo)
      .pipe(
        retry(2),
        catchError(this.handleError)
      )
  }

  // salva um carro
  saveMilitar(mil: Militar): Observable<Militar> {
    return this.httpClient.post<Militar>(this.url + '/saveMilitarAtivo/', JSON.stringify(mil), this.httpOptions)
      .pipe(
        retry(2),
        catchError(this.handleError)
      )
  }

  // utualiza um carro
  updateMilitar(mil: Militar): Observable<Militar> {
    return this.httpClient.put<Militar>(this.url + '/alterarMilitarAtivo/' + mil.id, JSON.stringify(mil), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  // deleta um carro
  deleteMilitar(mil: Militar) {
    return this.httpClient.delete<Militar>(this.url + 'deletarMilitarAtivo/' + mil, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
    console.log(mil);
  }

  // Manipulação de erros
  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };
}