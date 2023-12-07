package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.implementations;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao.ClienteDao;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Cliente;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public Cliente findByEmail(String email) {
        return clienteDao.findByEmail(email);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public Cliente validarCliente(String email, String password) {
        return clienteDao.findByEmailAndPassword(email,password);
    }
}
