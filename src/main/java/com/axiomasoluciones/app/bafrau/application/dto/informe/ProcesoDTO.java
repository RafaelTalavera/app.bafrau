package com.axiomasoluciones.app.bafrau.application.dto.informe;

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
    private List<Long> insumosIds; // IDs de los insumos relacionados
    private Long informeId; // ID del informe relacionado

    // Constructor por defecto
    public ProcesoDTO() {
    }

    // Constructor con parámetros
    public ProcesoDTO(Long id, String nombre, String producto, String subProducto, List<String> residuos, String acopioResiduos, String sitioResiduos, String recipienteResiduos, String residuosLiquidos, List<Long> insumosIds, Long informeId) {
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
        this.informeId = informeId;
    }

    // Getters y setters
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

    public Long getInformeId() {
        return informeId;
    }

    public void setInformeId(Long informeId) {
        this.informeId = informeId;
    }
}