package com.axiomasoluciones.app.bafrau.application.dto.informe;

public class ServicioDisponibleDTO {
    private Long id;
    private String servicio;
    private Long informeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Long getInformeId() {
        return informeId;
    }

    public void setInformeId(Long informeId) {
        this.informeId = informeId;
    }
}