package com.axiomasoluciones.app.bafrau.domain.entities.matriz;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Table(name = "matrices")
@Entity
public class Matriz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;


    @OneToMany(mappedBy="matriz",
            cascade=CascadeType.ALL,
            orphanRemoval=true)
    private List<ItemMatriz> items;

    public Matriz() {
    }

    public Matriz(Long id, LocalDate fecha, Organizacion organizacion, List<ItemMatriz> items) {
        this.id = id;
        this.fecha = fecha;
        this.organizacion = organizacion;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public List<ItemMatriz> getItems() {
        return items;
    }

    public void setItems(List<ItemMatriz> items) {
        this.items = items;
    }
}
