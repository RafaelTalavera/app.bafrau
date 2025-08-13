package com.axiomasoluciones.app.bafrau.application.dto.informe.informe;

import java.time.LocalDate;
import java.util.List;

public class InformePreviewDTO {
    public Long id;
    public String titulo;
    public String razonSocial;
    public LocalDate fecha;

    public List<CapituloLight> capitulos;
    public List<SeccionFull> secciones;     // incluye adjuntos y style
    public List<TablaFull> tablas;          // incluye filas y celdas

    public static class CapituloLight {
        public Long id;
        public String titulo;
        public Integer orden;
        public Long informeId;
    }

    public static class SeccionFull {
        public Long id;
        public Long capituloId;
        public Integer orden;
        public String contenido;
        public Long styleTemplateId;
        public List<AdjuntoItem> adjuntos;
    }

    public static class AdjuntoItem {
        public Long id;
        public String descripcion;
        public String urlAdjunto;
    }

    public static class TablaFull {
        public Long id;
        public Long seccionId;
        public String nombre;
        public List<FilaFull> filas;
    }

    public static class FilaFull {
        public Long id;
        public Integer numeroFila;
        public List<CeldaFull> celdas;
    }

    public static class CeldaFull {
        public Long id;
        public Integer numeroColumna;
        public String contenido;
    }
}