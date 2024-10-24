package com.axiomasoluciones.app.bafrau.domain.entities.tabla;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Columna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreColumna;
    private String tipoDato;

    @ManyToOne
    @JoinColumn(name = "tabla_id")
    private Tabla tabla;

    @OneToMany(mappedBy = "columna", cascade = CascadeType.ALL)
    private List<Celda> celdas;

    public Columna() {
    }

    public Columna(Long id, String nombreColumna, String tipoDato, Tabla tabla, List<Celda> celdas) {
        this.id = id;
        this.nombreColumna = nombreColumna;
        this.tipoDato = tipoDato;
        this.tabla = tabla;
        this.celdas = celdas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreColumna() {
        return nombreColumna;
    }

    public void setNombreColumna(String nombreColumna) {
        this.nombreColumna = nombreColumna;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
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
