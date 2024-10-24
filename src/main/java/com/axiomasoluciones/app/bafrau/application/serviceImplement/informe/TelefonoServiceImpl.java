package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.TelefonoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.TelefonoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.NominaEmpleados;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Telefono;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.ITelefonoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.ITelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TelefonoServiceImpl implements ITelefonoService {

    @Autowired
    private ITelefonoRepository telefonoRepository;

    @Autowired
    private TelefonoMapper telefonoMapper;

    @Override
    public List<TelefonoDTO> findAll() {
        List<Telefono> telefonos = (List<Telefono>) telefonoRepository.findAll();
        return telefonos.stream()
                .map(telefonoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TelefonoDTO> findById(Long id) {
        return telefonoRepository.findById(id)
                .map(telefonoMapper::toDto);
    }

    @Override
    public TelefonoDTO create(TelefonoDTO telefonoDTO) {
        Telefono telefono = telefonoMapper.toEntity(telefonoDTO);
        Telefono savedTelefono = telefonoRepository.save(telefono);
        return telefonoMapper.toDto(savedTelefono);
    }

    @Override
    public TelefonoDTO update(Long id, TelefonoDTO telefonoDTO) {
        if (telefonoRepository.existsById(id)) {
            Telefono telefono = telefonoMapper.toEntity(telefonoDTO);
            telefono.setId(id);  // Asegurar que el ID está presente en la entidad
            Telefono updatedTelefono = telefonoRepository.save(telefono);
            return telefonoMapper.toDto(updatedTelefono);
        }
        throw new RuntimeException("Teléfono no encontrado con el ID: " + id);
    }

    @Override
    public void delete(Long id) {
        if (telefonoRepository.existsById(id)) {
            telefonoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Teléfono no encontrado con el ID: " + id);
        }
    }

    @Override
    public List<TelefonoDTO> getTelefonosByInformeId(Long informeId) {
        List<Telefono> telefonos = telefonoRepository.findByInformeId(informeId);
        return telefonos.stream()
                .map(telefonoMapper::toDto)
                .collect(Collectors.toList());
    }
}