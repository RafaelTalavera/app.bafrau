package com.axiomasoluciones.app.bafrau.domain.entities.legal;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "control-Items")
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

    private List<String> listMail;

    private String observaciones;

    public ItemControl() {
    }

    public ItemControl(Long id, Documento documento, Control control, LocalDate vencimiento, List<String> listMail, String observaciones) {
        this.id = id;
        this.documento = documento;
        this.control = control;
        this.vencimiento = vencimiento;
        this.listMail = listMail;
        this.observaciones = observaciones;
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

    public List<String> getListMail() {
        return listMail;
    }

    public void setListMail(List<String> listMail) {
        this.listMail = listMail;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}