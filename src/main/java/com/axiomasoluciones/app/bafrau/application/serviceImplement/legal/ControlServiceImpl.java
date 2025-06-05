package com.axiomasoluciones.app.bafrau.application.serviceImplement.legal;

import com.axiomasoluciones.app.bafrau.application.dto.legal.ControlDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.legal.ControlMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.Control;
import com.axiomasoluciones.app.bafrau.domain.entities.legal.ItemControl;
import com.axiomasoluciones.app.bafrau.domain.repository.legal.ControlRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.legal.ItemsControlRepository;
import com.axiomasoluciones.app.bafrau.domain.services.legal.ControlService;
import com.axiomasoluciones.app.bafrau.domain.services.utility.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ControlServiceImpl implements ControlService {

    private final ControlRepository repository;
    private final ControlMapper mapper;
    private final EmailService emailService;
    private final ItemsControlRepository itemsControlRepository;
    private static final Logger log = LoggerFactory.getLogger(ControlServiceImpl.class);

    @Autowired
    public ControlServiceImpl(ControlRepository repository, ControlMapper mapper, EmailService emailService, ItemsControlRepository itemsControlRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.emailService = emailService;
        this.itemsControlRepository = itemsControlRepository;
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
        return repository.findAllWithItems().stream()
                .map(mapper::toDTO)
                .toList();
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
    
      

    @Override
    public ControlDTO editarControl(Long id, ControlDTO dto) {
        Control existente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Control no encontrado"));

        // MapStruct actualiza sólo los campos del DTO
        mapper.updateFromDto(dto, existente);

        // Aseguro la back-reference en items
        existente.getItems().forEach(item -> item.setControl(existente));

        Control actualizado = repository.save(existente);
        return mapper.toDTO(actualizado);
    }

}
