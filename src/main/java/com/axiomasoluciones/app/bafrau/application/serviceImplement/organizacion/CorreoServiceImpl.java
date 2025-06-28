package com.axiomasoluciones.app.bafrau.application.serviceImplement.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.CorreoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.organizacion.CorreoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Correo;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.CorreoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.ICorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CorreoServiceImpl implements ICorreoService {

    @Autowired
    private CorreoRepository correoRepository;

    @Autowired
    private CorreoMapper correoMapper;

    @Override
    public List<CorreoDTO> findAll() {
        List<Correo> correos = (List<Correo>) correoRepository.findAll();
        return correos.stream()
                .map(correoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CorreoDTO> findById(Long id) {
        return correoRepository.findById(id)
                .map(correoMapper::toDto);
    }

    @Override
    public CorreoDTO create(CorreoDTO correoDTO) {
        Correo correo = correoMapper.toEntity(correoDTO);
        Correo savedCorreo = correoRepository.save(correo);
        return correoMapper.toDto(savedCorreo);
    }

    @Override
    public CorreoDTO update(Long id, CorreoDTO correoDTO) {
        if (correoRepository.existsById(id)) {
            Correo correo = correoMapper.toEntity(correoDTO);
            correo.setId(id);  // Asegurarse de que el ID está presente en la entidad
            Correo updatedCorreo = correoRepository.save(correo);
            return correoMapper.toDto(updatedCorreo);
        }
        throw new RuntimeException("Correo no encontrado con el ID: " + id);
    }

    @Override
    public void delete(Long id) {
        if (correoRepository.existsById(id)) {
            correoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Correo no encontrado con el ID: " + id);
        }
    }

    @Override
    public List<CorreoDTO> getCorreosByOrganizacionId(Long organizacionId) {
        List<Correo> correos = correoRepository.findByOrganizacionId(organizacionId);
        return correos.stream()
                .map(correoMapper::toDto)
                .collect(Collectors.toList());
    }

}