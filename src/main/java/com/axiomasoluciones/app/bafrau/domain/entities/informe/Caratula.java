package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.utility.Auditable;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "caratulas")
public class Caratula extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String elaborador;

    /** Fecha en formato "MM-yyyy" */
    @Column(nullable = false, length = 7)
    private String fecha;

    // --- CAMBIO: relación con Informe, no con Capitulo ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id", nullable = false)
    private Informe informe;

    @OneToMany(mappedBy = "caratula",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @BatchSize(size = 64)
    private List<com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto> adjuntos = new ArrayList<>();

    public Caratula() {}

    // Constructor completo
    public Caratula(Long id, String titulo, String elaborador, String fecha,
                    Informe informe,
                    List<com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto> adjuntos) {
        this.id = id;
        this.titulo = titulo;
        this.elaborador = elaborador;
        this.fecha = fecha;
        this.informe = informe;
        setAdjuntos(adjuntos);
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getElaborador() { return elaborador; }
    public void setElaborador(String elaborador) { this.elaborador = elaborador; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Informe getInforme() { return informe; }
    public void setInforme(Informe informe) { this.informe = informe; }

    public List<com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto> getAdjuntos() {
        return adjuntos;
    }
    public void setAdjuntos(List<com.axiomasoluciones.app.bafrau.domain.entities.utility.Adjunto> nuevas) {
        this.adjuntos.clear();
        if (nuevas != null) {
            for (var a : nuevas) {
                a.setCaratula(this);
                this.adjuntos.add(a);
            }
        }
    }
}
