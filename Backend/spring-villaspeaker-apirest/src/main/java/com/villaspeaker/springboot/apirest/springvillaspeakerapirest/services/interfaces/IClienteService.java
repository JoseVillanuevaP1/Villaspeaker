package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Cliente;

public interface IClienteService {
    Cliente save(Cliente cliente);

    Cliente findByEmail(String email);

    Cliente findById(Long id);

    Cliente validarCliente(String email, String password);
}
