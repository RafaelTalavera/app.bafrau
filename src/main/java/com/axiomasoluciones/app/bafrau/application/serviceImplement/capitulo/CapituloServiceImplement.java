package com.axiomasoluciones.app.bafrau.application.serviceImplement.capitulo;

import com.axiomasoluciones.app.bafrau.application.dto.capitulo.CapituloDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.capitulo.CapituloMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.capitulo.Capitulo;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.repository.capitulo.CapituloRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.OrganizacionRepository;
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
    private OrganizacionRepository organizacionRepository;

    @Autowired
    private CapituloMapper capituloMapper;

    @Override
    public List<CapituloDTO> findAll() {
        List<Capitulo> capitulos = StreamSupport
                .stream(capituloRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

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
        Long organizacionId = capituloDTO.getOrganizacion().getId();
        Optional<Organizacion> organizacion = organizacionRepository.findById(organizacionId);
        if (organizacion.isPresent()) {
            Capitulo capitulo = capituloMapper.toCapitulo(capituloDTO);
            capitulo.setOrganizacion(organizacion.get());
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

            Long informeId = capituloDTO.getOrganizacion().getId();
            Optional<Organizacion> organizacion = organizacionRepository.findById(informeId);
            organizacion.ifPresent(capitulo::setOrganizacion);

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
