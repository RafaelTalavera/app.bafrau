package com.axiomasoluciones.app.bafrau.application.dto.informe.informe;

import java.time.LocalDate;

public class InformeListItemDTO {

    private Long id;
    private String titulo;
    private String razonSocial;
    private LocalDate fecha;
    private Long organizacionId;

    public InformeListItemDTO(Long id, String titulo, String razonSocial, LocalDate fecha, Long organizacionId) {
        this.id = id;
        this.titulo = titulo;
        this.razonSocial = razonSocial;
        this.fecha = fecha;
        this.organizacionId = organizacionId;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getRazonSocial() { return razonSocial; }
    public LocalDate getFecha() { return fecha; }
    public Long getOrganizacionId() { return organizacionId; }
}
