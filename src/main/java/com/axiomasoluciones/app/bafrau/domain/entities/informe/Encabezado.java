package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.Auditable;
import com.axiomasoluciones.app.bafrau.domain.entities.utility.StyleTemplate;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "encabezado")
@Entity
public class Encabezado extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id", nullable = false)
    private Informe informe;


    @OneToMany(mappedBy = "encabezado",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Adjunto> adjuntos = new ArrayList<>();

    public Encabezado() {
    }

    public Encabezado(Long id, String contenido, Informe informe, List<Adjunto> adjuntos) {
        this.id = id;
        this.contenido = contenido;
        this.informe = informe;
        this.adjuntos = adjuntos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public List<Adjunto> getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(List<Adjunto> adjuntos) {
        this.adjuntos = adjuntos;
    }
}
