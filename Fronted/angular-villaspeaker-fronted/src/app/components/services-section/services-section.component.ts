import { Component, OnInit, inject } from '@angular/core';
import { Categoria } from '../../models/categoria';
import { CategoriaService } from '../../services/categoria.service';
import { ActivatedRoute, RouterLink, RouterLinkActive } from '@angular/router';
import { ProductoService } from '../../services/producto.service';
import { Producto } from '../../models/producto';

@Component({
  selector: 'app-services-section',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './services-section.component.html',
  styleUrl: './services-section.component.css',
})
export class ServicesSectionComponent implements OnInit {
  categorias!: Categoria[];
  productos!: Producto[];
  categoriaService = inject(CategoriaService);
  productoService = inject(ProductoService);
  private activatedRoute: ActivatedRoute = inject(ActivatedRoute);

  ngOnInit(): void {
    this.categoriaService
      .getCategorias()
      .subscribe((categorias) => (this.categorias = categorias));

    this.cargarProductos();
  }

  cargarProductos(): void {
    this.activatedRoute.params.subscribe((params) => {
      let id = params['id'];
      if (id) {
        console.log(id);
        this.productoService.getProductosById(id).subscribe((productos) => {
          this.productos = productos;
          console.log(this.productos)
        });
      }
    });
  }
}
