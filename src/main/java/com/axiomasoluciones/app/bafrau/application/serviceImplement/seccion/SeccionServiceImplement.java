package com.axiomasoluciones.app.bafrau.application.serviceImplement.seccion;

import com.axiomasoluciones.app.bafrau.application.dto.seccion.SeccionDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.seccion.SeccionMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.capitulo.Capitulo;
import com.axiomasoluciones.app.bafrau.domain.entities.seccion.Seccion;
import com.axiomasoluciones.app.bafrau.domain.repository.seccion.SeccionRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.capitulo.CapituloRepository;
import com.axiomasoluciones.app.bafrau.domain.services.seccion.ISeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SeccionServiceImplement implements ISeccionService {

    @Autowired
    private SeccionRepository seccionRepository;

    @Autowired
    private CapituloRepository capituloRepository;

    @Autowired
    private SeccionMapper seccionMapper;

    @Override
    public List<SeccionDTO> findAll() {
        List<Seccion> secciones = StreamSupport
                .stream(seccionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return secciones.stream()
                .map(seccionMapper::toSeccionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SeccionDTO> findById(Long id) {
        return seccionRepository.findById(id)
                .map(seccionMapper::toSeccionDTO);
    }

    @Override
    public SeccionDTO create(SeccionDTO seccionDTO) {
        // Asegurarse de que la sección esté asociada a un capítulo existente
        Long capituloId = seccionDTO.getCapituloId();
        Optional<Capitulo> capitulo = capituloRepository.findById(capituloId);

        if (capitulo.isPresent()) {
            Seccion seccion = seccionMapper.toSeccion(seccionDTO);
            seccion.setCapitulo(capitulo.get()); // Asociar la sección al capítulo
            Seccion savedSeccion = seccionRepository.save(seccion);
            return seccionMapper.toSeccionDTO(savedSeccion);
        }
        throw new IllegalArgumentException("No se encontró el capítulo asociado con la sección");
    }

    @Override
    public SeccionDTO update(Long id, SeccionDTO seccionDTO) {
        Optional<Seccion> existingSeccion = seccionRepository.findById(id);
        if (existingSeccion.isPresent()) {
            Seccion seccion = seccionMapper.toSeccion(seccionDTO);
            seccion.setId(id);
            Seccion updatedSeccion = seccionRepository.save(seccion);
            return seccionMapper.toSeccionDTO(updatedSeccion);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        seccionRepository.deleteById(id);
    }
}