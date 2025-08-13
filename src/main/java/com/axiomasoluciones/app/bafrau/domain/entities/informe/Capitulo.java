package com.axiomasoluciones.app.bafrau.domain.entities.informe;

import com.axiomasoluciones.app.bafrau.domain.entities.utility.Auditable;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Table(name = "capitulos")
@Entity
public class Capitulo extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private int orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informe_id", nullable = false)
    private Informe informe;

    @OneToMany(mappedBy = "capitulo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @BatchSize(size = 64)
    private List<Seccion> secciones = new ArrayList<>();

    public Capitulo() {}

    public Capitulo(Long id, String titulo, int orden, Informe informe, List<Seccion> secciones) {
        this.id = id;
        this.titulo = titulo;
        this.orden = orden;
        this.informe = informe;
        setSecciones(secciones);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }

    public Informe getInforme() { return informe; }
    public void setInforme(Informe informe) { this.informe = informe; }

    public List<Seccion> getSecciones() { return secciones; }


    // Solo un setter mutando la lista existente
    public void setSecciones(List<Seccion> nuevas) {
        this.secciones.clear();
        if (nuevas != null) {
            for (Seccion s : nuevas) {
                s.setCapitulo(this);
                this.secciones.add(s);
            }
        }
    }
}
