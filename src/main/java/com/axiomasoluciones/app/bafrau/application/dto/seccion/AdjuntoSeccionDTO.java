package com.axiomasoluciones.app.bafrau.application.dto.seccion;

public class AdjuntoSeccionDTO {

    private Long id;
    private String urlAdjunto;
    private String descripcion;
    private Long seccionId; // Relacionamos solo con el ID de la Seccion

    public AdjuntoSeccionDTO() {
    }

    public AdjuntoSeccionDTO(Long id, String urlAdjunto, String descripcion, Long seccionId) {
        this.id = id;
        this.urlAdjunto = urlAdjunto;
        this.descripcion = descripcion;
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

    public Long getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(Long seccionId) {
        this.seccionId = seccionId;
    }
}
