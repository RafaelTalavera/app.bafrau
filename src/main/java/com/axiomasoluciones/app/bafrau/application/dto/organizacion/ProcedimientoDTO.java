package com.axiomasoluciones.app.bafrau.application.dto.organizacion;

public class ProcedimientoDTO {

    private Long id;
    private String nombre;
    private String adjunto;
    private Long organizacionId;

    public ProcedimientoDTO() {
    }

    public ProcedimientoDTO(Long id, String nombre, String adjunto, Long organizacionId) {
        this.id = id;
        this.nombre = nombre;
        this.adjunto = adjunto;
        this.organizacionId = organizacionId;
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

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }
}