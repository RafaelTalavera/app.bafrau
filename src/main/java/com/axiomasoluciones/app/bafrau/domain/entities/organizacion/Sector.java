package com.axiomasoluciones.app.bafrau.domain.entities.organizacion;


import jakarta.persistence.*;

@Entity
@Table(name = "organizaciones_sectores")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sector;

    private double m2;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    public Sector() {
    }

    public Sector(Long id, String sector, double m2, Organizacion organizacion) {
        this.id = id;
        this.sector = sector;
        this.m2 = m2;
        this.organizacion = organizacion;
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

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}
