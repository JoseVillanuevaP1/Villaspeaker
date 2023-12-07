package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Categoria;

import java.util.List;

public interface ICategoriaService {

    List<Categoria> findAll();

}
