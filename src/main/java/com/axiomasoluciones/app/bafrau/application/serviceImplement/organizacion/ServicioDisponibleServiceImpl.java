package com.axiomasoluciones.app.bafrau.application.serviceImplement.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ServicioDisponibleDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.organizacion.ServicioDisponibleMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.ServicioDisponible;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.IServicioDisponibleRepository;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.IServicioDisponibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioDisponibleServiceImpl implements IServicioDisponibleService {

    @Autowired
    private IServicioDisponibleRepository servicioDisponibleRepository;

    @Autowired
    private ServicioDisponibleMapper servicioDisponibleMapper;

    @Override
    public List<ServicioDisponibleDTO> findAll() {
        List<ServicioDisponible> servicios = (List<ServicioDisponible>) servicioDisponibleRepository.findAll();
        return servicios.stream()
                .map(servicioDisponibleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ServicioDisponibleDTO> findById(Long id) {
        return servicioDisponibleRepository.findById(id)
                .map(servicioDisponibleMapper::toDto);
    }

    @Override
    public ServicioDisponibleDTO create(ServicioDisponibleDTO servicioDisponibleDTO) {
        ServicioDisponible servicio = servicioDisponibleMapper.toEntity(servicioDisponibleDTO);
        ServicioDisponible savedServicio = servicioDisponibleRepository.save(servicio);
        return servicioDisponibleMapper.toDto(savedServicio);
    }

    @Override
    public ServicioDisponibleDTO update(Long id, ServicioDisponibleDTO servicioDisponibleDTO) {
        if (servicioDisponibleRepository.existsById(id)) {
            ServicioDisponible servicio = servicioDisponibleMapper.toEntity(servicioDisponibleDTO);
            servicio.setId(id);  // Asegurar que el ID está presente en la entidad
            ServicioDisponible updatedServicio = servicioDisponibleRepository.save(servicio);
            return servicioDisponibleMapper.toDto(updatedServicio);
        }
        throw new RuntimeException("Servicio no encontrado con el ID: " + id);
    }

    @Override
    public void delete(Long id) {
        if (servicioDisponibleRepository.existsById(id)) {
            servicioDisponibleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Servicio no encontrado con el ID: " + id);
        }
    }

    @Override
    public List<ServicioDisponibleDTO> getServicioDisponibleByOrganizacionId(Long organizacionId) {
        List<ServicioDisponible> servicios = servicioDisponibleRepository.findByOrganizacionId(organizacionId);
        return servicios.stream()
                .map(servicioDisponibleMapper::toDto)
                .collect(Collectors.toList());
    }
}
