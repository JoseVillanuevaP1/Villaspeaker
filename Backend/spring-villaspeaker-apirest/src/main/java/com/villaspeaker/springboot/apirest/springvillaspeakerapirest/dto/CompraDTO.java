package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompraDTO {
    private Long idCliente;
    private Long idPago;
    private List<DetalleCompraDTO> detalles;
    private Double monto;
    private String estado;
    private String fechaCompra;
}
