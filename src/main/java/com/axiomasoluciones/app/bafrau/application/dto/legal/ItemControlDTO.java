package com.axiomasoluciones.app.bafrau.application.dto.legal;

import java.time.LocalDate;
import java.util.Set;

public class ItemControlDTO {
    private Long id;
    private Long documentoId;
    private Long controlId;
    private LocalDate vencimiento;
    private int diasNotificacion;
    private Set<String> listMail;
    private String observaciones;
    private String nombre;                    // de Documento.nombre
    private String juridiccion;               // de Documento.juridiccion
    private String observacionesDocumento;    // de Documento.observaciones
    private String razonSocial;

    public ItemControlDTO() { }

    public ItemControlDTO(Long id, Long documentoId, Long controlId, LocalDate vencimiento, int diasNotificacion, Set<String> listMail, String observaciones, String nombre, String juridiccion, String observacionesDocumento, String razonSocial) {
        this.id = id;
        this.documentoId = documentoId;
        this.controlId = controlId;
        this.vencimiento = vencimiento;
        this.diasNotificacion = diasNotificacion;
        this.listMail = listMail;
        this.observaciones = observaciones;
        this.nombre = nombre;
        this.juridiccion = juridiccion;
        this.observacionesDocumento = observacionesDocumento;
        this.razonSocial = razonSocial;
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

    public int getDiasNotificacion() {
        return diasNotificacion;
    }

    public void setDiasNotificacion(int diasNotificacion) {
        this.diasNotificacion = diasNotificacion;
    }

    public Set<String> getListMail() {
        return listMail;
    }

    public void setListMail(Set<String> listMail) {
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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}
