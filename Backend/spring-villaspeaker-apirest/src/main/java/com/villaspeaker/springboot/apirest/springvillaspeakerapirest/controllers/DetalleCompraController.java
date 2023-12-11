package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.controllers;


import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.DetalleCompra;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IDetalleCompraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DetalleCompraController {

    private final IDetalleCompraService detalleCompraService;

    public DetalleCompraController(IDetalleCompraService detalleCompraService) {
        this.detalleCompraService = detalleCompraService;
    }

    @GetMapping("/detalles/{id}")
    public List<DetalleCompra> index(@PathVariable Long id){
        return  detalleCompraService.findByIdCompra(id);
    }

}
