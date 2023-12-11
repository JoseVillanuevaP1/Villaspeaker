import { Injectable, inject } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Categoria } from '../models/categoria';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class CategoriaService {

  private urlEndPoint: string = 'http://localhost:8080/api/categorias';
  private http: HttpClient = inject(HttpClient);
  private httpHeaders: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  private router: Router = inject(Router);

  constructor() {}

  getCategorias(): Observable<Categoria[]> {
    return this.http
      .get(this.urlEndPoint)
      .pipe(map((response) => response as Categoria[]));
  }
}
