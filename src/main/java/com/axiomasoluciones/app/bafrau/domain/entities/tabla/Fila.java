package com.axiomasoluciones.app.bafrau.domain.entities.tabla;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tabla_id")
    private Tabla tabla;

    @OneToMany(mappedBy = "fila", cascade = CascadeType.ALL)
    private List<Celda> celdas;

    public Fila() {
    }

    public Fila(Long id, Tabla tabla, List<Celda> celdas) {
        this.id = id;
        this.tabla = tabla;
        this.celdas = celdas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public List<Celda> getCeldas() {
        return celdas;
    }

    public void setCeldas(List<Celda> celdas) {
        this.celdas = celdas;
    }
}
