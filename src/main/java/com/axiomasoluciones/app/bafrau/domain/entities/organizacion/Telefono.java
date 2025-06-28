package com.axiomasoluciones.app.bafrau.domain.entities.organizacion;

import jakarta.persistence.*;

@Entity
@Table(name = "organizaciones_telefonos")
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")  // Llave foránea a la entidad Informe
    private Organizacion organizacion;

    private String nombre;

    public Telefono() {}

    public Telefono(Long id, String telefono, Organizacion organizacion, String nombre) {
        this.id = id;
        this.telefono = telefono;
        this.organizacion = organizacion;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}