
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


    // Obtem todos os carros
  getMilitarAll(): Observable<Militar[]> {
    return this.httpClient.get<Militar[]>(this.url + 'militarAtivo')
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

   getCarByNome(nome: string):Observable<Militar[]> {
    return this.httpClient.get<Militar[]>(this.url + '/militarNomeEfetivo/' + nome)
      .pipe(
        retry(2),
        catchError(this.handleError)
      )
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