package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;




import com.axiomasoluciones.app.bafrau.application.dto.informe.capitulo.CapituloLightDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.informe.InformePreviewDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Seccion;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Tabla;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Fila;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InformePreviewService {

    private final InformeRepository informeRepo;
    private final CapituloRepository capituloRepo;
    private final SeccionRepository seccionRepo;
    private final TablaRepository tablaRepo;
    private final FilaRepository filaRepo;

    public InformePreviewService(InformeRepository informeRepo,
                                 CapituloRepository capituloRepo,
                                 SeccionRepository seccionRepo,
                                 TablaRepository tablaRepo,
                                 FilaRepository filaRepo) {
        this.informeRepo = informeRepo;
        this.capituloRepo = capituloRepo;
        this.seccionRepo = seccionRepo;
        this.tablaRepo = tablaRepo;
        this.filaRepo = filaRepo;
    }

    @Transactional(readOnly = true)
    public InformePreviewDTO build(Long informeId) {
        // 1) Cabecera muy liviana
        var inf = informeRepo.findById(informeId)
                .orElseThrow(() -> new NoSuchElementException("Informe no encontrado: " + informeId));

        // 2) Capítulos livianos (ya tenés este método)
        List<CapituloLightDTO> caps = capituloRepo.findLightByInformeIdOrderByOrdenAsc(informeId);

        // 3) Secciones con adjuntos + style en 1 query
        List<Seccion> secciones = seccionRepo.findByInformeIdWithAdjuntosAndStyle(informeId);
        List<Long> seccionIds = secciones.stream().map(Seccion::getId).toList();

        // 4) Tablas por secciones (1 query)
        List<Tabla> tablas = seccionIds.isEmpty() ? List.of() : tablaRepo.findBySeccionIdIn(seccionIds);
        List<Long> tablaIds = tablas.stream().map(Tabla::getId).toList();

        // 5) Filas + celdas en 1 query
        List<Fila> filas = tablaIds.isEmpty() ? List.of() : filaRepo.findByTablaIdInWithCeldas(tablaIds);

        // Mapear DTO
        var dto = new InformePreviewDTO();
        dto.id = inf.getId();
        dto.titulo = inf.getTitulo();
        dto.razonSocial = inf.getRazonSocial();
        dto.fecha = inf.getFecha();

        dto.capitulos = caps.stream().map(c -> {
            var x = new InformePreviewDTO.CapituloLight();
            x.id = c.getId();
            x.titulo = c.getTitulo();
            x.orden = c.getOrden();
            x.informeId = c.getInformeId();
            return x;
        }).toList();


        dto.secciones = secciones.stream().map(s -> {
            var x = new InformePreviewDTO.SeccionFull();
            x.id = s.getId();
            x.capituloId = s.getCapitulo().getId();
            x.orden = s.getOrden();
            x.contenido = s.getContenido();
            x.styleTemplateId = s.getStyleTemplate() != null ? s.getStyleTemplate().getId() : null;
            x.adjuntos = s.getAdjuntos().stream().map(a -> {
                var y = new InformePreviewDTO.AdjuntoItem();
                y.id = a.getId();
                y.descripcion = a.getDescripcion();
                y.urlAdjunto = a.getUrlAdjunto();
                return y;
            }).toList();
            return x;
        }).toList();

        // Agrupar filas por tabla
        Map<Long, List<Fila>> filasPorTabla = filas.stream()
                .collect(Collectors.groupingBy(f -> f.getTabla().getId(), LinkedHashMap::new, Collectors.toList()));

        dto.tablas = tablas.stream().map(t -> {
            var xt = new InformePreviewDTO.TablaFull();
            xt.id = t.getId();
            xt.seccionId = t.getSeccion().getId();
            xt.nombre = t.getNombre();

            var filasDeTabla = filasPorTabla.getOrDefault(t.getId(), List.of());
            xt.filas = filasDeTabla.stream().map(f -> {
                var xf = new InformePreviewDTO.FilaFull();
                xf.id = f.getId();
                xf.numeroFila = f.getNumeroFila();
                xf.celdas = f.getCeldas().stream().sorted(Comparator.comparingInt(c -> c.getNumeroColumna()))
                        .map(c -> {
                            var xc = new InformePreviewDTO.CeldaFull();
                            xc.id = c.getId();
                            xc.numeroColumna = c.getNumeroColumna();
                            xc.contenido = c.getContenido();
                            return xc;
                        }).toList();
                return xf;
            }).toList();

            return xt;
        }).toList();

        return dto;
    }
}