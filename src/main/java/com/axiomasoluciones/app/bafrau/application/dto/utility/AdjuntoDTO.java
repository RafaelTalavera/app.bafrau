package com.axiomasoluciones.app.bafrau.application.dto.utility;

public class AdjuntoDTO {

    private Long id;
    private String urlAdjunto;
    private String descripcion;
    private Long organizacionId;
    private Long seccionId;

    public AdjuntoDTO() {
    }

    public AdjuntoDTO(Long id, String urlAdjunto, String descripcion, Long organizacionId, Long seccionId) {
        this.id = id;
        this.urlAdjunto = urlAdjunto;
        this.descripcion = descripcion;
        this.organizacionId = organizacionId;
        this.seccionId = seccionId;
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

    public Long getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Long seccionId) {
        this.seccionId = seccionId;
    }
}
