package com.axiomasoluciones.app.bafrau.application.serviceImplement.tabla;

import com.axiomasoluciones.app.bafrau.application.dto.tabla.TablaDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.tabla.TablaMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.seccion.Seccion;
import com.axiomasoluciones.app.bafrau.domain.entities.tabla.Tabla;

import com.axiomasoluciones.app.bafrau.domain.repository.seccion.SeccionRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.tabla.TablaRepository;
import com.axiomasoluciones.app.bafrau.domain.services.tabla.ITablaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TablaServiceImplement implements ITablaService {

    @Autowired
    private TablaRepository tablaRepository;

    @Autowired
    private SeccionRepository seccionRepository;

    @Autowired
    private TablaMapper tablaMapper;

    @Override
    public List<TablaDTO> findAll() {
        // Convertir el Iterable en una List
        List<Tabla> tablas = StreamSupport
                .stream(tablaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        // Mapear las Tablas a TablaDTO
        return tablas.stream()
                .map(tablaMapper::toTablaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TablaDTO> findById(Long id) {
        return tablaRepository.findById(id)
                .map(tablaMapper::toTablaDTO);
    }

    @Override
    public TablaDTO create(TablaDTO tablaDTO) {
        // Asegurarse de que la tabla esté asociada a una sección existente
        Long seccionId = tablaDTO.getSeccionId();
        Optional<Seccion> seccion = seccionRepository.findById(seccionId);
        if (seccion.isPresent()) {
            Tabla tabla = tablaMapper.toTabla(tablaDTO);
            tabla.setSeccion(seccion.get());  // Asociar la tabla a la sección
            Tabla savedTabla = tablaRepository.save(tabla);
            return tablaMapper.toTablaDTO(savedTabla);
        }
        throw new IllegalArgumentException("No se encontró la sección asociada con la tabla");
    }

    @Override
    public TablaDTO update(Long id, TablaDTO tablaDTO) {
        Optional<Tabla> existingTabla = tablaRepository.findById(id);
        if (existingTabla.isPresent()) {
            Tabla tabla = tablaMapper.toTabla(tablaDTO);
            tabla.setId(id);
            Tabla updatedTabla = tablaRepository.save(tabla);
            return tablaMapper.toTablaDTO(updatedTabla);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        tablaRepository.deleteById(id);
    }
}