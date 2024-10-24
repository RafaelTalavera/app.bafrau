package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import jakarta.persistence.*;

@Entity
@Table(name = "informe_telefonos")
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "informe_id")  // Llave foránea a la entidad Informe
    private Informe informe;

    private String nombre;

    public Telefono() {}

    public Telefono(Long id, String telefono, Informe informe, String nombre) {
        this.id = id;
        this.telefono = telefono;
        this.informe = informe;
        this.nombre = nombre;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public Telefono(String telefono) {
        this.telefono = telefono;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}