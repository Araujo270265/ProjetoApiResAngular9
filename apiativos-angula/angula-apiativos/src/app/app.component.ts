import { ServiceMilitaresService } from './services/service-militares.service';
import { Component, OnInit } from '@angular/core';
import { Militar } from './models/militar';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'angula-apiativos';
  
  militar = {} as Militar;
  militares: Militar[];

   nome: string = "" ;
   public pagina: number;
   public tamanhoPagina: number;

  constructor(private militarService: ServiceMilitaresService) {}

  ngOnInit() { 
    this.getCargetMilitaresAlls();
  }

  addtext(){
    console.log("Este e meu nome:", this.nome);
  } 

// Chama o serviço para obtém todos os carros
getCargetMilitaresAlls() {
  this.militarService.getMilitarAll().subscribe((militares: Militar[]) => {
    this.militares = militares;
  });
}

getCarByNome(nome: string) {
  this.militarService.getCarByNome(nome).subscribe((militares: Militar[]) => {
    this.militares = militares;
    console.log(this.militares);
  });
}

}
