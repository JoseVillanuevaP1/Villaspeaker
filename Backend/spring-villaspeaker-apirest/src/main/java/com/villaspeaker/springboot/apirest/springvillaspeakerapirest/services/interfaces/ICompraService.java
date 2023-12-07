package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Compra;

public interface ICompraService {

    Compra save(Compra compra);

    Compra findById(Long id);
}
