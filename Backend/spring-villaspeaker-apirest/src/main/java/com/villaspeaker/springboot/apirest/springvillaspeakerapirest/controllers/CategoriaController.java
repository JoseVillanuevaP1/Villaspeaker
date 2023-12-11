package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.controllers;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Categoria;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<Categoria> index(){
        return categoriaService.findAll();
    }

}
