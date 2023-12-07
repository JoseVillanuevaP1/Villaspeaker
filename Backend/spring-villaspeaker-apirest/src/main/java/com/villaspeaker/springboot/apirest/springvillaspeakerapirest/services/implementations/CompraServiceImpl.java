package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.implementations;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao.CompraDao;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Compra;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements ICompraService {

    @Autowired
    private CompraDao compraDao;

    @Override
    public Compra save(Compra compra) {
        return compraDao.save(compra);
    }

    @Override
    public Compra findById(Long id) {
        return compraDao.findById(id).orElse(null);
    }
}
