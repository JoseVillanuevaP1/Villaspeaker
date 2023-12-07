package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.implementations;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dao.DetallesCompraDao;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.DetalleCompra;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IDetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleCompraServiceImpl implements IDetalleCompraService {

    @Autowired
    private DetallesCompraDao compraDao;

    @Override
    public List<DetalleCompra> findByIdCompra(Long id) {
        return compraDao.findByCompraId(id);
    }

    @Override
    public DetalleCompra save(DetalleCompra detalleCompra) {
        return compraDao.save(detalleCompra);
    }

    @Override
    public List<DetalleCompra> findAll() {
        return (List<DetalleCompra>) compraDao.findAll();
    }


}
