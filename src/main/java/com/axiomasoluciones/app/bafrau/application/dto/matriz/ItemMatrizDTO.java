package com.axiomasoluciones.app.bafrau.application.dto.matriz;


public class ItemMatrizDTO {
    private Long id;
    private int magnitude;
    private int importance;
    private Long accionId;
    private Long factorId;

    public ItemMatrizDTO() {
    }

    public ItemMatrizDTO(Long id, int magnitude, int importance, Long accionId, Long factorId) {
        this.id = id;
        this.magnitude = magnitude;
        this.importance = importance;
        this.accionId = accionId;
        this.factorId = factorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public Long getAccionId() {
        return accionId;
    }

    public void setAccionId(Long accionId) {
        this.accionId = accionId;
    }

    public Long getFactorId() {
        return factorId;
    }

    public void setFactorId(Long factorId) {
        this.factorId = factorId;
    }
}