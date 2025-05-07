package com.axiomasoluciones.app.bafrau.application.dto.legal;

import java.time.LocalDate;
import java.util.List;

public class ItemControlDTO {
    private Long id;
    private Long documentoId;
    private Long controlId;
    private LocalDate vencimiento;
    private List<String> listMail;
    private String observaciones;
    private String nombre;                    // de Documento.nombre
    private String juridiccion;               // de Documento.juridiccion
    private String observacionesDocumento;    // de Documento.observaciones

    public ItemControlDTO() { }

    public ItemControlDTO(Long id, Long documentoId, Long controlId, LocalDate vencimiento, List<String> listMail, String observaciones, String observaciones1, String nombre, String juridiccion, String observacionesDocumento) {
        this.id = id;
        this.documentoId = documentoId;
        this.controlId = controlId;
        this.vencimiento = vencimiento;
        this.listMail = listMail;
        this.observaciones = observaciones;
        this.observaciones = observaciones1;
        this.nombre = nombre;
        this.juridiccion = juridiccion;
        this.observacionesDocumento = observacionesDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(Long documentoId) {
        this.documentoId = documentoId;
    }

    public Long getControlId() {
        return controlId;
    }

    public void setControlId(Long controlId) {
        this.controlId = controlId;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public List<String> getListMail() {
        return listMail;
    }

    public void setListMail(List<String> listMail) {
        this.listMail = listMail;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJuridiccion() {
        return juridiccion;
    }

    public void setJuridiccion(String juridiccion) {
        this.juridiccion = juridiccion;
    }

    public String getObservacionesDocumento() {
        return observacionesDocumento;
    }

    public void setObservacionesDocumento(String observacionesDocumento) {
        this.observacionesDocumento = observacionesDocumento;
    }
}
