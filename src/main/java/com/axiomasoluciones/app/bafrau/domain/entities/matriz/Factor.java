package com.axiomasoluciones.app.bafrau.domain.entities.matriz;

import jakarta.persistence.*;


@Table(name = "factores")
@Entity
public class Factor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clasificacion;
    private String tipo;

    public Factor() {
    }

    public Factor(Long id, String clasificacion, String tipo) {
        this.id = id;
        this.clasificacion = clasificacion;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
