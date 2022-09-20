import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  categorias(){
      this.router.navigate(['category'])
  }

  subcategorias(){
    this.router.navigate(['sub-category'])
  }

  documentos(){
    this.router.navigate(['document'])
  }

  reportes(){
    this.router.navigate(['reports'])
  }

}
