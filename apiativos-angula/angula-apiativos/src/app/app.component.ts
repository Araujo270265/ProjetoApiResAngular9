import { ServiceMilitaresService } from './services/service-militares.service';
import { Component, OnInit } from '@angular/core';
import { Militar } from './models/militar';
import { NgForm } from '@angular/forms';

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
  efetivo: string = "";
  paginaAtual : Number = 1 ;

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

getCarByNome(nome: string, efetivo: string) {
  this.militarService.getCarByNome(nome, efetivo).subscribe((militares: Militar[]) => {
    this.militares = militares;
  });
}

saveMilitar(form: NgForm) {
  if (this.militar.id !== undefined) {
    this.militarService.updateMilitar(this.militar).subscribe(() => {
      this.cleanForm(form);
    });
  } else {
    this.militarService.saveMilitar(this.militar).subscribe(() => {
      this.cleanForm(form);
    });
  }
}

editMilitar(mililtar: Militar) {
  this.militar = { ...mililtar };
}

// limpa o formulario
cleanForm(form: NgForm) {
  this.getCargetMilitaresAlls();
  form.resetForm();
  this.militar = {} as Militar;
}

deleteMilitar(mililtar: Militar) {
  this.militarService.deleteMilitar(mililtar).subscribe(() => {
    this.getCargetMilitaresAlls();
  });
}


}
