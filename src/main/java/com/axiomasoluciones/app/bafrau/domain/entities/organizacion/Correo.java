package com.axiomasoluciones.app.bafrau.domain.entities.organizacion;

import jakarta.persistence.*;

@Entity
@Table(name = "organizaciones_correos")
public class Correo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "correo", nullable = false)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")  // Llave foránea a la entidad Informe
    private Organizacion organizacion;

    public Correo() {}

    public Correo(Long id, String nombre, String correo, Organizacion organizacion) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.organizacion = organizacion;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}