package com.axiomasoluciones.app.bafrau.application.serviceImplement.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ControlDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.legal.ControlMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.Control;
import com.axiomasoluciones.app.bafrau.domain.repository.legal.ControlRepository;
import com.axiomasoluciones.app.bafrau.domain.services.legal.ControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ControlServiceImpl implements ControlService {

    private final ControlRepository repository;
    private final ControlMapper mapper;

    @Autowired
    public ControlServiceImpl(ControlRepository repository, ControlMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ControlDTO crearControl(ControlDTO dto) {
        Control control = mapper.toEntity(dto);
        // fijar back-reference
        control.getItems().forEach(item -> item.setControl(control));
        Control guardado = repository.save(control);
        return mapper.toDTO(guardado);
    }


    @Override
    public List<ControlDTO> obtenerTodos() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ControlDTO obtenerPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Control no encontrado"));
    }

    @Override
    public void eliminarControl(Long id) {
        Optional<Control> controlOpt = repository.findById(id);
        if (controlOpt.isPresent()) {
            repository.delete(controlOpt.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Control no encontrado");
        }
    }
}
