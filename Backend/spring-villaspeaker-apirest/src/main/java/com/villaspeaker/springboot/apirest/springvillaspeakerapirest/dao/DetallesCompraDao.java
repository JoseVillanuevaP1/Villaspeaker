package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.DetalleCompra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetallesCompraDao extends CrudRepository<DetalleCompra, Long> {

    List<DetalleCompra> findByCompraId(Long id);

}
