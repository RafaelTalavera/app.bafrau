package com.axiomasoluciones.app.bafrau.domain.entities.informe;


import jakarta.persistence.*;

@Entity
@Table(name = "insumos")
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String fichaTecnica;

    @ManyToOne
    @JoinColumn(name = "proceso_id") // Relaciona Insumo con Proceso
    private Proceso proceso;

    public Insumo() {
    }

    public Insumo(Long id, String nombre, String fichaTecnica, Proceso proceso) {
        this.id = id;
        this.nombre = nombre;
        this.fichaTecnica = fichaTecnica;
        this.proceso = proceso;
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

    public String getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(String fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }
}
