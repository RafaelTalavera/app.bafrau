package com.axiomasoluciones.app.bafrau.application.dto.organizacion;

import java.util.List;

public class ProcesoDTO {

    private Long id;
    private String nombre;
    private String producto;
    private String subProducto;
    private List<String> residuos;
    private String acopioResiduos;
    private String sitioResiduos;
    private String recipienteResiduos;
    private String residuosLiquidos;
    private List<Long> insumosIds;
    private Long organizacionId;

    public ProcesoDTO() {
    }

    public ProcesoDTO(Long id, String nombre, String producto, String subProducto, List<String> residuos, String acopioResiduos, String sitioResiduos, String recipienteResiduos, String residuosLiquidos, List<Long> insumosIds, Long organizacionId) {
        this.id = id;
        this.nombre = nombre;
        this.producto = producto;
        this.subProducto = subProducto;
        this.residuos = residuos;
        this.acopioResiduos = acopioResiduos;
        this.sitioResiduos = sitioResiduos;
        this.recipienteResiduos = recipienteResiduos;
        this.residuosLiquidos = residuosLiquidos;
        this.insumosIds = insumosIds;
        this.organizacionId = organizacionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getSubProducto() {
        return subProducto;
    }

    public void setSubProducto(String subProducto) {
        this.subProducto = subProducto;
    }

    public List<String> getResiduos() {
        return residuos;
    }

    public void setResiduos(List<String> residuos) {
        this.residuos = residuos;
    }

    public String getAcopioResiduos() {
        return acopioResiduos;
    }

    public void setAcopioResiduos(String acopioResiduos) {
        this.acopioResiduos = acopioResiduos;
    }

    public String getSitioResiduos() {
        return sitioResiduos;
    }

    public void setSitioResiduos(String sitioResiduos) {
        this.sitioResiduos = sitioResiduos;
    }

    public String getRecipienteResiduos() {
        return recipienteResiduos;
    }

    public void setRecipienteResiduos(String recipienteResiduos) {
        this.recipienteResiduos = recipienteResiduos;
    }

    public String getResiduosLiquidos() {
        return residuosLiquidos;
    }

    public void setResiduosLiquidos(String residuosLiquidos) {
        this.residuosLiquidos = residuosLiquidos;
    }

    public List<Long> getInsumosIds() {
        return insumosIds;
    }

    public void setInsumosIds(List<Long> insumosIds) {
        this.insumosIds = insumosIds;
    }

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }
}