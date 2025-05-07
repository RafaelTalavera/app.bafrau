package com.axiomasoluciones.app.bafrau.application.dto.legal;


public class DocumentoDTO {

    private Long id;
    private String nombre;
    private String juridiccion;
    private String observaciones;

    public DocumentoDTO() {
    }

    public DocumentoDTO(Long id, String nombre, String juridiccion, String observaciones) {
        this.id = id;
        this.nombre = nombre;
        this.juridiccion = juridiccion;
        this.observaciones = observaciones;
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

    public String getJuridiccion() {
        return juridiccion;
    }

    public void setJuridiccion(String juridiccion) {
        this.juridiccion = juridiccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
