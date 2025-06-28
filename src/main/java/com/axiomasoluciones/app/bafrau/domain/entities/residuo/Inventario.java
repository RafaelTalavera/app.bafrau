package com.axiomasoluciones.app.bafrau.domain.entities.residuo;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "residuos-inventarios")
@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    private String contrato;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "inventario")
    private List<ItemInventario> items;

    public Inventario() {
    }

    public Inventario(Long id, LocalDate fecha, Organizacion organizacion, String contrato, List<ItemInventario> items) {
        this.id = id;
        this.fecha = fecha;
        this.organizacion = organizacion;
        this.contrato = contrato;
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

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public List<ItemInventario> getItems() {
        return items;
    }

    public void setItems(List<ItemInventario> items) {
        this.items = items;
    }
}
