package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.controllers;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dto.ProductoDTO;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<ProductoDTO> index() {
        return productoService.findAll().stream().map(ProductoDTO::new).toList();
    }

    @GetMapping("/productos/{id}")
    public List<ProductoDTO> indexCategory(@PathVariable Long id) {
        return productoService.findByCategoriaId(id).stream().map(ProductoDTO::new).toList();
    }
}
