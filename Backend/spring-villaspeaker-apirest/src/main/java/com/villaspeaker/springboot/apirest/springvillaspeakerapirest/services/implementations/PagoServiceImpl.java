package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.implementations;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao.PagoDao;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Pago;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl implements IPagoService {

    @Autowired
    private PagoDao pagoDao;

    @Override
    public Pago save(Pago pago) {
        return pagoDao.save(pago);
    }

    @Override
    public Pago findById(Long id) {
        return pagoDao.findById(id).orElse(null);
    }
}
