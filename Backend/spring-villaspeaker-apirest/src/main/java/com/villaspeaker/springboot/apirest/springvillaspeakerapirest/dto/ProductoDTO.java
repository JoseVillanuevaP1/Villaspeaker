package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dto;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Producto;

public class ProductoDTO {

    private Long id;
    private String nombre;
    private String foto;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private Long idCategoria;

    public ProductoDTO(Producto producto) {

        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.foto = producto.getFoto();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecio();
        this.stock = producto.getStock();

        if (producto.getCategoria() != null) {
            this.idCategoria = producto.getCategoria().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long categoriaId) {
        this.idCategoria = categoriaId;
    }
}