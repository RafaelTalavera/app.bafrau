package com.axiomasoluciones.app.bafrau.domain.entities.organizacion;


import jakarta.persistence.*;

@Entity
@Table(name = "organizaciones_procedimientos")
public class Procedimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String adjunto;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    public Procedimiento() {
    }

    public Procedimiento(Long id, String nombre, String adjunto, Organizacion organizacion) {
        this.id = id;
        this.nombre = nombre;
        this.adjunto = adjunto;
        this.organizacion = organizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}
