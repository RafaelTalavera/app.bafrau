package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import jakarta.persistence.*;

@Entity
@Table(name = "informe_servicios_disponibles")
public class ServicioDisponible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "servicio", nullable = false)
    private String servicio;

    @ManyToOne
    @JoinColumn(name = "informe_id")  // Llave foránea a la entidad Informe
    private Informe informe;

    public ServicioDisponible() {}

    public ServicioDisponible(Long id, String servicio, Informe informe) {
        this.id = id;
        this.servicio = servicio;
        this.informe = informe;
    }

    public ServicioDisponible(String servicio) {
        this.servicio = servicio;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }
}