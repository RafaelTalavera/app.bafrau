package com.axiomasoluciones.app.bafrau.services.implement;

import com.axiomasoluciones.app.bafrau.dto.request.AccionRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.AccionResponseDTO;
import com.axiomasoluciones.app.bafrau.models.dao.AccionRepository;
import com.axiomasoluciones.app.bafrau.models.entities.Accion;
import com.axiomasoluciones.app.bafrau.services.IAccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccionServiceImplement implements IAccionService {

   @Autowired
    AccionRepository accionRepository;

    @Override
    public List<AccionResponseDTO> findAll() {

        Iterable<Accion> accions = accionRepository.findAll();
        return StreamSupport.stream(accions.spliterator(),false)
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AccionResponseDTO> findById(Long id) {
        return accionRepository.findById(id).map(this::convertToResponseDTO);
    }

    @Override
    public AccionResponseDTO createAccion(AccionRequestDTO accionRequestDTO) {

        Accion newAccion = new Accion(
                accionRequestDTO.getClasificacion(),
                accionRequestDTO.getTipo()
        );

        Accion savedAccion = accionRepository.save(newAccion);

        return new AccionResponseDTO(
                savedAccion.getId(),
                savedAccion.getClasificacion(),
                savedAccion.getTipo()
        );
    }

    @Override
    public void deleteById(Long id) {
        accionRepository.deleteById(id);
    }

    @Override
    public AccionResponseDTO editedAccion(Long id, AccionRequestDTO editedAccionRequestDTO) {
        Optional<Accion> optionalAccion = accionRepository.findById(id);
        if (optionalAccion.isPresent()) {
            Accion accion = optionalAccion.get();
            accion.setClasificacion(editedAccionRequestDTO.getClasificacion());
            accion.setTipo(editedAccionRequestDTO.getTipo());
            Accion updatedAccion = accionRepository.save(accion);
            return convertToResponseDTO(updatedAccion);
        }

        return null;
    }

    @Override
    public List<AccionResponseDTO> findByClasificacion(String clasificacion) {

        Iterable<Accion> accions = accionRepository.findByClasificacion(clasificacion);
        return StreamSupport.stream(accions.spliterator(),false)
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());

    }

    private AccionResponseDTO convertToResponseDTO (Accion accion){
        AccionResponseDTO dto = new AccionResponseDTO();
        dto.setId(accion.getId());
        dto.setClasificacion(accion.getClasificacion());
        dto.setTipo(accion.getTipo());

        return dto;
    }
}
