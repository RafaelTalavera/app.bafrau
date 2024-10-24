package com.axiomasoluciones.app.bafrau.domain.entities.informe;


import jakarta.persistence.*;

@Entity
@Table(name = "sectores")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sector;

    private double m2;

    @ManyToOne
    @JoinColumn(name = "informe_id")  // Relacionar Sector con Informe
    private Informe informe;

    public Sector() {
    }

    public Sector(Long id, String sector, double m2, Informe informe) {
        this.id = id;
        this.sector = sector;
        this.m2 = m2;
        this.informe = informe;
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

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }
}
