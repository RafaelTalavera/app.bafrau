package com.axiomasoluciones.app.bafrau.application.dto.informe;

import com.axiomasoluciones.app.bafrau.application.dto.utility.AdjuntoDTO;

import java.time.Instant;
import java.util.List;

public class EncabezadoDTO {
    private Long id;
    private String contenido;
    private Long informeId;

    private List<AdjuntoDTO> adjuntos;
    private List<Long> adjuntosIds;

    // Auditoría
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public EncabezadoDTO() {
    }

    public EncabezadoDTO(Long id, String contenido, Long informeId, List<AdjuntoDTO> adjuntos, List<Long> adjuntosIds, String createdBy, Instant createdDate, String lastModifiedBy, Instant lastModifiedDate) {
        this.id = id;
        this.contenido = contenido;
        this.informeId = informeId;
        this.adjuntos = adjuntos;
        this.adjuntosIds = adjuntosIds;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getInformeId() {
        return informeId;
    }

    public void setInformeId(Long informeId) {
        this.informeId = informeId;
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
}
