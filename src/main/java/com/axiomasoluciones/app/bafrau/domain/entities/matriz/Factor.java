package com.axiomasoluciones.app.bafrau.domain.entities.matriz;

import jakarta.persistence.*;


@Table(name = "factores")
@Entity
public class Factor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sistema;
    private String subsistema;
    private String factor;
    private String componente;
    public Factor() {
    }

    public Factor(Long id, String sistema, String subsistema, String factor, String componente) {
        this.id = id;
        this.sistema = sistema;
        this.subsistema = subsistema;
        this.factor = factor;
        this.componente = componente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getSubsistema() {
        return subsistema;
    }

    public void setSubsistema(String subsistema) {
        this.subsistema = subsistema;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }
}
