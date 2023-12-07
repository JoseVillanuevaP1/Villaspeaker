package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> findAll();

    List<Producto> findByCategoriaId(Long id);

    Producto findById(Long id);

}
