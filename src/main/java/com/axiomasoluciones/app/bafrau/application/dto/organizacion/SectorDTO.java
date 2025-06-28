package com.axiomasoluciones.app.bafrau.application.dto.organizacion;

public class SectorDTO {

    private Long id;
    private String sector;
    private double m2;
    private Long organizacionId;

    public SectorDTO() {
    }

    public SectorDTO(Long id, String sector, double m2, Long organizacionId) {
        this.id = id;
        this.sector = sector;
        this.m2 = m2;
        this.organizacionId = organizacionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public Long getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Long organizacionId) {
        this.organizacionId = organizacionId;
    }
}
