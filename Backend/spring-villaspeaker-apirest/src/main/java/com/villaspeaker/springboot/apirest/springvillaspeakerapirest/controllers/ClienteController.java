package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.controllers;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Cliente;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping("/clientes")
    public Cliente index(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> findClient(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        Cliente client = clienteService.findById(id);

        if (client == null) {
            response.put("msg", "Error, Usuario no existe. Por favor verifique sus credenciales o registrese.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

}
