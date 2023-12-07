package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import java.io.Serializable;

@Getter
@Entity
@Table(name = "detalle_compra")
@JsonIgnoreProperties({"producto","compra"})
public class DetalleCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;

    private Double precioCompra;

    private Double importe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproducto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compra_id")
    private Compra compra;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    private static final long serialVersionUID = 1L;
}
