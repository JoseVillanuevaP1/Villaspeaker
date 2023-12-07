package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoDao extends CrudRepository<Producto, Long> {

    List<Producto> findByCategoriaId(Long idCategoria);

}
