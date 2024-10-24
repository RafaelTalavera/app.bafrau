package com.axiomasoluciones.app.bafrau.application.serviceImplement.capitulo;

import com.axiomasoluciones.app.bafrau.application.dto.capitulo.CapituloDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.capitulo.CapituloMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.capitulo.Capitulo;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import com.axiomasoluciones.app.bafrau.domain.repository.capitulo.CapituloRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.InformeRepository;
import com.axiomasoluciones.app.bafrau.domain.services.capitulo.ICapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CapituloServiceImplement implements ICapituloService {

    @Autowired
    private CapituloRepository capituloRepository;

    @Autowired
    private InformeRepository informeRepository;

    @Autowired
    private CapituloMapper capituloMapper;

    @Override
    public List<CapituloDTO> findAll() {
        // Convertir el Iterable en una List
        List<Capitulo> capitulos = StreamSupport
                .stream(capituloRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        // Mapear los Capitulo a CapituloDTO
        return capitulos.stream()
                .map(capituloMapper::toCapituloDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CapituloDTO> findById(Long id) {
        return capituloRepository.findById(id)
                .map(capituloMapper::toCapituloDTO);
    }

    @Override
    public CapituloDTO create(CapituloDTO capituloDTO) {
        // Asegurarse de que el capítulo esté asociado a un informe existente
        Long informeId = capituloDTO.getInforme().getId(); // Obtener el informeId directamente desde el DTO
        Optional<Informe> informe = informeRepository.findById(informeId);
        if (informe.isPresent()) {
            Capitulo capitulo = capituloMapper.toCapitulo(capituloDTO);
            capitulo.setInforme(informe.get());  // Asociar capítulo a informe
            Capitulo savedCapitulo = capituloRepository.save(capitulo);
            return capituloMapper.toCapituloDTO(savedCapitulo);
        }
        throw new IllegalArgumentException("No se encontró el informe asociado con el capítulo");
    }

    @Override
    public CapituloDTO update(Long id, CapituloDTO capituloDTO) {
        Optional<Capitulo> existingCapitulo = capituloRepository.findById(id);
        if (existingCapitulo.isPresent()) {
            Capitulo capitulo = capituloMapper.toCapitulo(capituloDTO);
            capitulo.setId(id);

            // Verificar si el informe también necesita actualización
            Long informeId = capituloDTO.getInforme().getId();
            Optional<Informe> informe = informeRepository.findById(informeId);
            informe.ifPresent(capitulo::setInforme);

            Capitulo updatedCapitulo = capituloRepository.save(capitulo);
            return capituloMapper.toCapituloDTO(updatedCapitulo);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        capituloRepository.deleteById(id);
    }
}
