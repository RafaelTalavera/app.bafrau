package com.axiomasoluciones.app.bafrau.domain.entities.legal;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "controles")
@Entity
public class Control {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    private LocalDate fecha;

    @OneToMany(
            mappedBy = "control",
            cascade = CascadeType.ALL,      // <- permitirá persistir items
            orphanRemoval = true
    )
    private List<ItemControl> items = new ArrayList<>();


    public Control() {
    }

    public Control(Long id, Organizacion organizacion, LocalDate fecha, List<ItemControl> items) {
        this.id = id;
        this.organizacion = organizacion;
        this.fecha = fecha;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<ItemControl> getItems() {
        return items;
    }

    public void setItems(List<ItemControl> items) {
        this.items = items;
    }
}
