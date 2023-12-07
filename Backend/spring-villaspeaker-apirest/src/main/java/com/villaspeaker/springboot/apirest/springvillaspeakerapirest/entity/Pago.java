package com.villaspeaker.springboot.apirest.springvillaspeakerapirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Entity
@Table(name = "pago")
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @OneToOne(mappedBy = "pago")
    @JsonIgnore
    private Compra compra;

    @PrePersist
    public void prePersist(){
        fecha = new Date();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    private static final long serialVersionUID = 1L;
}
