package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import jakarta.persistence.*;

@Entity
@Table(name = "informe_correos")
public class Correo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "correo", nullable = false)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "informe_id")  // Llave foránea a la entidad Informe
    private Informe informe;

    public Correo() {}

    public Correo(Long id, String nombre, String correo, Informe informe) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.informe = informe;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public Correo(String correo) {
        this.correo = correo;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}