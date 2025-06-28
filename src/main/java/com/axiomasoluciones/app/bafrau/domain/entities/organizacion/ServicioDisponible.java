package com.axiomasoluciones.app.bafrau.domain.entities.organizacion;

import jakarta.persistence.*;

@Entity
@Table(name = "organizaciones_servicios_disponibles")
public class ServicioDisponible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "servicio", nullable = false)
    private String servicio;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")  // Llave foránea a la entidad Informe
    private Organizacion organizacion;

    public ServicioDisponible() {}

    public ServicioDisponible(Long id, String servicio, Organizacion organizacion) {
        this.id = id;
        this.servicio = servicio;
        this.organizacion = organizacion;
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

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}