package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CeldaDTO;
import com.axiomasoluciones.app.bafrau.application.dto.informe.TablaDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.TablaMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Celda;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Fila;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Seccion;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Tabla;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.CeldaRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.TablaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablaService {
    private final TablaRepository tablaRepo;
    private final TablaMapper tablaMapper;
    private final CeldaRepository celdaRepository;

    public TablaService(TablaRepository tablaRepo, TablaMapper tablaMapper, CeldaRepository celdaRepository) {
        this.tablaRepo = tablaRepo;
        this.tablaMapper = tablaMapper;
        this.celdaRepository = celdaRepository;
    }

    public TablaDTO crearTabla(Integer numFilas, Integer numColumnas, Long seccionId, String nombre) {
        // 1) Armá la entidad Tabla
        Tabla tabla = new Tabla();
        tabla.setNombre(nombre);
        tabla.setSeccion(new Seccion());
        tabla.getSeccion().setId(seccionId);

        // 2) Generá filas y celdas
        for (int i = 0; i < numFilas; i++) {
            Fila fila = new Fila();
            fila.setNumeroFila(i);
            fila.setTabla(tabla);

            for (int j = 0; j < numColumnas; j++) {
                Celda celda = new Celda();
                celda.setNumeroColumna(j);
                celda.setContenido("");
                celda.setFila(fila);
                fila.getCeldas().add(celda);
            }
            tabla.getFilas().add(fila);
        }

        // 3) Guardar y devolver DTO
        Tabla guardada = tablaRepo.save(tabla);
        return tablaMapper.toDto(guardada);
    }

    public List<TablaDTO> listarPorSeccion(Long seccionId) {
        return tablaRepo.findBySeccionId(seccionId).stream()
                .map(tablaMapper::toDto)
                .toList();
    }

    public void actualizarVariasCeldas(List<CeldaDTO> celdas) {
        for (CeldaDTO dto : celdas) {
            Celda celda = celdaRepository.findById(dto.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Celda no encontrada"));
            celda.setContenido(dto.getContenido());
        }
    }

    public void eliminarTabla(Long tablaId) {
        if (!tablaRepo.existsById(tablaId)) {
            throw new EntityNotFoundException("Tabla con id " + tablaId + " no encontrada");
        }
        tablaRepo.deleteById(tablaId);
    }

}
