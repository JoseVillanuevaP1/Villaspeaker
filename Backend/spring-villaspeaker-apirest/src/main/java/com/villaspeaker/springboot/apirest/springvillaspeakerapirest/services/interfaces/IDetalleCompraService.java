package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.DetalleCompra;

import java.util.List;

public interface IDetalleCompraService {

    List<DetalleCompra> findByIdCompra(Long id);

    DetalleCompra save(DetalleCompra detalleCompra);

    List<DetalleCompra> findAll();

}
