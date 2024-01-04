package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.controllers;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Cliente;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping("/clientes")
    public ResponseEntity<?> index(@RequestBody Cliente cliente) {

        Map<String, Object> response = new HashMap<>();

        if (clienteService.findByEmail(cliente.getEmail()) != null) {
            response.put("msg", "Error, Usuario ya existe en la base de datos.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Cliente clienteSave;
        try {
            clienteSave = clienteService.save(cliente);
        } catch (DataAccessException e){
            response.put("msg", "Error al registrar Cliente");
            response.put("error ", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("msg","Cliente registrado con exito");
        response.put("cliente", clienteSave);
        return new ResponseEntity<>(clienteSave, HttpStatus.OK);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> findClient(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        Cliente client = clienteService.findById(id);

        if (client == null) {
            response.put("msg", "Error, Cliente no existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/clientes2/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {

        Map<String, Object> response = new HashMap<>();
        Cliente client = clienteService.findByEmail(email);

        if (client == null) {
            response.put("msg", "Error, Cliente no existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/clientes/validate")
    @ResponseBody
    public ResponseEntity<?> validateClient(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        Map<String, Object> response = new HashMap<>();
        Cliente cliente = clienteService.validarCliente(email, password);

        if (cliente == null) {
            response.put("msg", "Error, Verifique sus datos o regístrese por favor.");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }

        response.put("msg", "Ingreso exitoso.");
        response.put("cliente", cliente);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
