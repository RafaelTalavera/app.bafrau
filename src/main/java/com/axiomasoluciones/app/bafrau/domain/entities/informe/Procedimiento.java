package com.axiomasoluciones.app.bafrau.domain.entities.informe;


import jakarta.persistence.*;

@Entity
@Table(name = "procedimientos")
public class Procedimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String adjunto;

    @ManyToOne
    @JoinColumn(name = "informe_id")
    private Informe informe;

    public Procedimiento() {
    }

    public Procedimiento(Long id, String nombre, String adjunto, Informe informe) {
        this.id = id;
        this.nombre = nombre;
        this.adjunto = adjunto;
        this.informe = informe;
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

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }
}
