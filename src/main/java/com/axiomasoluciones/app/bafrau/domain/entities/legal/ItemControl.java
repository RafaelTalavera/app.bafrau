package com.axiomasoluciones.app.bafrau.domain.entities.legal;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "control-items")
public class ItemControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "documento_id")
    private Documento documento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "control_id")
    private Control control;

    private LocalDate vencimiento;

    private LocalDate presentacion;

    private int diasNotificacion;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "itemcontrol_emails",
            joinColumns = @JoinColumn(name = "item_control_id"))
    @Column(name = "email")
    @Fetch(FetchMode.SUBSELECT)
    private Set<String> listMail = new HashSet<>();

    private String observaciones;

    private Boolean estado;

    public ItemControl() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public int getDiasNotificacion() {
        return diasNotificacion;
    }

    public void setDiasNotificacion(int diasNotificacion) {
        this.diasNotificacion = diasNotificacion;
    }

    public Set<String> getListMail() {
        return listMail;
    }

    public void setListMail(Set<String> listMail) {
        this.listMail = listMail;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(LocalDate presentacion) {
        this.presentacion = presentacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}