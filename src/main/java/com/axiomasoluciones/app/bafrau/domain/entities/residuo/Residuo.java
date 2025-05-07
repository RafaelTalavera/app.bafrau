package com.axiomasoluciones.app.bafrau.domain.entities.residuo;

import jakarta.persistence.*;

@Table(name = "residuos")
@Entity
public class Residuo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String corriente;

    private String juridiccion;

    private String detalle;

    public Residuo() {
    }

    public Residuo(Long id, String corriente, String juridiccion, String detalle) {
        this.id = id;
        this.corriente = corriente;
        this.juridiccion = juridiccion;
        this.detalle = detalle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorriente() {
        return corriente;
    }

    public void setCorriente(String corriente) {
        this.corriente = corriente;
    }

    public String getJuridiccion() {
        return juridiccion;
    }

    public void setJuridiccion(String juridiccion) {
        this.juridiccion = juridiccion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
