import { Component, OnInit, inject } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { CategoriaService } from '../../services/categoria.service';
import { Categoria } from '../../models/categoria';
declare var $: any;

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent implements OnInit {
  
  categorias!: Categoria[];
  firstname: string = 'Villa';
  secondname: string = 'Speaker';
  categoriaService = inject(CategoriaService);

  ngOnInit(): void {
    this.categoriaService
      .getCategorias()
      .subscribe((categorias) => (this.categorias = categorias));
  }
}
