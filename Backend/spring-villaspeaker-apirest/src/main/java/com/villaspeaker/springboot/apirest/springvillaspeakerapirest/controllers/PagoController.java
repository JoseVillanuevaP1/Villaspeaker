package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.controllers;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Pago;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PagoController {

    @Autowired
    IPagoService pagoService;

    @PostMapping("/pagos")
    public Pago index(@RequestBody Pago pago){
        return pagoService.save(pago);
    }

    @GetMapping("/pagos/{id}")
    public Pago index2(@PathVariable Long id){
        return pagoService.findById(id);
    }

}
