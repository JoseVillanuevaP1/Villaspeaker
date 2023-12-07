package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {

    Cliente findByEmailAndPassword(String email, String password);

    Cliente findByEmail(String email);

}
