package com.axiomasoluciones.app.bafrau.application.dto.informe;

import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;

import java.time.Instant;
import java.util.List;

public class SeccionDTO {

    private Long id;
    private int orden;
    private String contenido;
    private Long capituloId;
    private Long organizacionId;
    private String razonSocial;
    private Long styleTemplateId;
    private String styleTemplateNombre;
    private List<AdjuntoDTO> adjuntos;
    private List<Long> adjuntosIds;

    // Auditoría
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public SeccionDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getCapituloId() {
        return capituloId;
    }

    public void setCapituloId(Long capituloId) {
        this.capituloId = capituloId;
    }

    public Long getStyleTemplateId() {
        return styleTemplateId;
    }

    public void setStyleTemplateId(Long styleTemplateId) {
        this.styleTemplateId = styleTemplateId;
    }

    public List<AdjuntoDTO> getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(List<AdjuntoDTO> adjuntos) {
        this.adjuntos = adjuntos;
    }

    public List<Long> getAdjuntosIds() {
        return adjuntosIds;
    }

    public void setAdjuntosIds(List<Long> adjuntosIds) {
        this.adjuntosIds = adjuntosIds;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getStyleTemplateNombre() {
        return styleTemplateNombre;
    }

    public void setStyleTemplateNombre(String styleTemplateNombre) {
        this.styleTemplateNombre = styleTemplateNombre;
    }
}
