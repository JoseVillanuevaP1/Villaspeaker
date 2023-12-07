package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria, Long> {
}
