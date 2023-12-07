package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Pago;

public interface IPagoService {

    Pago save(Pago pago);

    Pago findById(Long id);
}
