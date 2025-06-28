package com.axiomasoluciones.app.bafrau.application.dto.organizacion;

public class ServicioDisponibleDTO {
    private Long id;
    private String servicio;
    private Long organizacionId;

    public ServicioDisponibleDTO() {
    }

    public ServicioDisponibleDTO(Long id, String servicio, Long organizacionId) {
        this.id = id;
        this.servicio = servicio;
        this.organizacionId = organizacionId;
    }

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

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }
}