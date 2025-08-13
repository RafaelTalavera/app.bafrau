package com.axiomasoluciones.app.bafrau.application.dto.informe.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.capitulo.CapituloDTO;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class InformeDTO {

    private Long id;
    private String titulo;
    private String razonSocial;
    private LocalDate fecha;
    private Long organizacionId;
    private List<CapituloDTO> capitulos;

    // Campos de auditoría
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public InformeDTO() {}

    public InformeDTO(Long id, String titulo, String razonSocial, LocalDate fecha, Long organizacionId, List<CapituloDTO> capitulos, String createdBy, Instant createdDate, String lastModifiedBy, Instant lastModifiedDate) {
        this.id = id;
        this.titulo = titulo;
        this.razonSocial = razonSocial;
        this.fecha = fecha;
        this.organizacionId = organizacionId;
        this.capitulos = capitulos;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }

    public List<CapituloDTO> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<CapituloDTO> capitulos) {
        this.capitulos = capitulos;
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
