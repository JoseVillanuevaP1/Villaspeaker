package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.controllers;

import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dto.CompraDTO;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.dto.DetalleCompraDTO;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Cliente;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Compra;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.DetalleCompra;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity.Pago;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IClienteService;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.ICompraService;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IPagoService;
import com.villaspeaker.springboot.apirest.springvillaspeakerapirest.services.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CompraController {

    @Autowired
    private ICompraService compraService;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IPagoService pagoService;

    @Autowired
    private IProductoService productoService;

    @PostMapping("/compras")
    public ResponseEntity<?> index(@RequestBody CompraDTO compraDTO) {

        Map<String, Object> response = new HashMap<>();
        Cliente cliente = clienteService.findById(compraDTO.getIdCliente());
        Pago pago = pagoService.findById(compraDTO.getIdPago());

        if (cliente == null) {
            response.put("msg", "Error, No se pudo realizar compra, el cliente no existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        if (pago == null) {
            response.put("msg", "Error, El cliente no ha realizado el pago");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setPago(pago);
        compra.setEstado("pagado");

        List<DetalleCompra> detalles = new ArrayList<>();

        double total = 0.0;
        for (DetalleCompraDTO detalleDTO : compraDTO.getDetalles()) {

            DetalleCompra detalle = new DetalleCompra();
            detalle.setProducto(productoService.findById(detalleDTO.getIdProducto()));
            detalle.setCantidad(detalleDTO.getCantidad());
            detalle.setPrecioCompra(detalleDTO.getPrecioCompra());

            double importe  = detalleDTO.getCantidad() * detalleDTO.getPrecioCompra();
            total += importe;

            detalle.setImporte(importe);
            detalle.setCompra(compra);
            detalles.add(detalle);
        }
        compra.setDetalleCompra(detalles);
        compra.setMonto(total);

        try {
            compra = compraService.save(compra);
        } catch (DataAccessException e) {
            response.put("msg", "Error al realizar compra");
            response.put("error ", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("msg", "La compra se ha realizado con exito");
        response.put("compra", compra);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/compras/{id}")
    public Compra index2(@PathVariable Long id){
        return compraService.findById(id);
    }
}
