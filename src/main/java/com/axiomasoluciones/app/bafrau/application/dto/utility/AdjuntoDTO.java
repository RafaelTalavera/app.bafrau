package com.axiomasoluciones.app.bafrau.application.dto.utility;

public class AdjuntoDTO {

    private Long id;
    private String urlAdjunto;
    private String descripcion;
    private Long organizacionId;

    public AdjuntoDTO() {
    }

    public AdjuntoDTO(Long id, String urlAdjunto, String descripcion, Long organizacionId) {
        this.id = id;
        this.urlAdjunto = urlAdjunto;
        this.descripcion = descripcion;
        this.organizacionId = organizacionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlAdjunto() {
        return urlAdjunto;
    }

    public void setUrlAdjunto(String urlAdjunto) {
        this.urlAdjunto = urlAdjunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }
}
