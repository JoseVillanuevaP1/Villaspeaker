package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleCompraDTO {
    private Long idProducto;
    private Integer cantidad;
    private Double precioCompra;
}
