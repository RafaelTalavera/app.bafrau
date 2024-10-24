package com.axiomasoluciones.app.bafrau.application.dto.informe;

public class ProcedimientoDTO {

    private Long id;
    private String nombre;
    private String adjunto;
    private Long informeId;

    // Constructor por defecto
    public ProcedimientoDTO() {
    }

    // Constructor con parámetros
    public ProcedimientoDTO(Long id, String nombre, String adjunto, Long informeId) {
        this.id = id;
        this.nombre = nombre;
        this.adjunto = adjunto;
        this.informeId = informeId;
    }

    // Getters y setters
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

    public Long getInformeId() {
        return informeId;
    }

    public void setInformeId(Long informeId) {
        this.informeId = informeId;
    }
}