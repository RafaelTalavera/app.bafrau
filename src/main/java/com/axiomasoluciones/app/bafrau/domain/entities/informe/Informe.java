package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Auditable;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "informes")
@Entity
public class Informe extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String razonSocial;

    private LocalDate fecha;

    @OneToMany(mappedBy = "informe",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @BatchSize(size = 64)
    private List<Capitulo> capitulos;

    @OneToMany(mappedBy = "informe",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @BatchSize(size = 64)
    private List<Encabezado> encabezados;

    @OneToMany(mappedBy = "informe",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @BatchSize(size = 64)
    private List<Caratula> caratulas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id",
            nullable = false)
    private Organizacion organizacion;

    public Informe() {
    }

    public Informe(Long id, String titulo, String razonSocial, LocalDate fecha, List<Capitulo> capitulos, List<Encabezado> encabezados, List<Caratula> caratulas, Organizacion organizacion) {
        this.id = id;
        this.titulo = titulo;
        this.razonSocial = razonSocial;
        this.fecha = fecha;
        this.capitulos = capitulos;
        this.encabezados = encabezados;
        this.caratulas = caratulas;
        this.organizacion = organizacion;
    }

    public List<Caratula> getCaratulas() {
        return caratulas;
    }

    public void setCaratulas(List<Caratula> caratulas) {
        this.caratulas = caratulas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    public List<Encabezado> getEncabezados() {
        return encabezados;
    }

    public void setEncabezados(List<Encabezado> encabezados) {
        this.encabezados = encabezados;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}
