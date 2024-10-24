package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CorreoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.CorreoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Correo;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Telefono;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.CorreoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.ICorreoService;
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
    public List<CorreoDTO> getCorreosByInformeId(Long informeId) {
        List<Correo> correos = correoRepository.findByInformeId(informeId);
        return correos.stream()
                .map(correoMapper::toDto)
                .collect(Collectors.toList());
    }

}