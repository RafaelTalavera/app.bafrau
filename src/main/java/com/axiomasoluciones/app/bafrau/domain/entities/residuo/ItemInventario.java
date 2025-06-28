package com.axiomasoluciones.app.bafrau.domain.entities.residuo;

import jakarta.persistence.*;

@Table(name = "residuos-items-inventarios")
@Entity
public class ItemInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventario_id", nullable = false)
    private Inventario inventario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "residuo_id", nullable = false)
    private Residuo residuo;

    public ItemInventario() { }

    public ItemInventario(Long id, Inventario inventario, Residuo residuo) {
        this.id = id;
        this.inventario = inventario;
        this.residuo = residuo;
    }

    // --- getters & setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuo) {
        this.residuo = residuo;
    }
}