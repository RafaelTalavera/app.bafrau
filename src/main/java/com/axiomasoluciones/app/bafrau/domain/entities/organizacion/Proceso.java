package com.axiomasoluciones.app.bafrau.domain.entities.organizacion;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "organizaciones_procesos")
public class Proceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String producto;

    private String subProducto;

    @ElementCollection
    @CollectionTable(name = "proceso_residuos", joinColumns = @JoinColumn(name = "proceso_id"))
    @Column(name = "residuo")
    private List<String> residuos;


    private String acopioResiduos;

    private String sitioResiduos;

    private String recipienteResiduos;

    private String residuosLiquidos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "proceso_id") // Define la FK en la tabla de Insumo
    private List<Insumo> insumos; // Cambiado a una lista de insumos para representar la relación OneToMany

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    public Proceso() {
    }

    public Proceso(Long id, String nombre, String producto, String subProducto, List<String> residuos, String acopioResiduos, String sitioResiduos, String recipienteResiduos, String residuosLiquidos, List<Insumo> insumos, Organizacion organizacion) {
        this.id = id;
        this.nombre = nombre;
        this.producto = producto;
        this.subProducto = subProducto;
        this.residuos = residuos;
        this.acopioResiduos = acopioResiduos;
        this.sitioResiduos = sitioResiduos;
        this.recipienteResiduos = recipienteResiduos;
        this.residuosLiquidos = residuosLiquidos;
        this.insumos = insumos;
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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getSubProducto() {
        return subProducto;
    }

    public void setSubProducto(String subProducto) {
        this.subProducto = subProducto;
    }

    public List<String> getResiduos() {
        return residuos;
    }

    public void setResiduos(List<String> residuos) {
        this.residuos = residuos;
    }

    public String getAcopioResiduos() {
        return acopioResiduos;
    }

    public void setAcopioResiduos(String acopioResiduos) {
        this.acopioResiduos = acopioResiduos;
    }

    public String getSitioResiduos() {
        return sitioResiduos;
    }

    public void setSitioResiduos(String sitioResiduos) {
        this.sitioResiduos = sitioResiduos;
    }

    public String getRecipienteResiduos() {
        return recipienteResiduos;
    }

    public void setRecipienteResiduos(String recipienteResiduos) {
        this.recipienteResiduos = recipienteResiduos;
    }

    public String getResiduosLiquidos() {
        return residuosLiquidos;
    }

    public void setResiduosLiquidos(String residuosLiquidos) {
        this.residuosLiquidos = residuosLiquidos;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}
