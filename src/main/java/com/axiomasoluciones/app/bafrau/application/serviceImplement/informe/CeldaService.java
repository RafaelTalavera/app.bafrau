package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.CeldaDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.CeldaMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Celda;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Fila;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.CeldaRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.FilaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CeldaService {

    private final CeldaRepository celdaRepo;
    private final FilaRepository filaRepo;
    private final CeldaMapper celdaMapper;

    public CeldaService(CeldaRepository celdaRepo, FilaRepository filaRepo, CeldaMapper celdaMapper) {
        this.celdaRepo = celdaRepo;
        this.filaRepo = filaRepo;
        this.celdaMapper = celdaMapper;
    }

    public CeldaDTO findById(Long id) {
        return celdaRepo.findById(id)
                .map(celdaMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Celda no encontrada con ID: " + id));
    }

    public List<CeldaDTO> findByFilaId(Long filaId) {
        return celdaRepo.findByFilaIdOrderByNumeroColumnaAsc(filaId).stream()
                .map(celdaMapper::toDto)
                .toList();
    }

    public CeldaDTO create(CeldaDTO dto) {
        Fila fila = filaRepo.findById(dto.getFilaId())
                .orElseThrow(() -> new EntityNotFoundException("Fila no encontrada con ID: " + dto.getFilaId()));

        Celda celda = celdaMapper.toEntity(dto);
        celda.setFila(fila);
        Celda saved = celdaRepo.save(celda);
        return celdaMapper.toDto(saved);
    }

    public CeldaDTO update(Long id, CeldaDTO dto) {
        Celda celda = celdaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Celda no encontrada con ID: " + id));

        celda.setContenido(dto.getContenido());
        celda.setNumeroColumna(dto.getNumeroColumna());
        Celda updated = celdaRepo.save(celda);
        return celdaMapper.toDto(updated);
    }

    public void delete(Long id) {
        if (!celdaRepo.existsById(id)) {
            throw new EntityNotFoundException("Celda no encontrada con ID: " + id);
        }
        celdaRepo.deleteById(id);
    }

    public void actualizarVarias(List<CeldaDTO> celdas) {
        for (CeldaDTO dto : celdas) {
            update(dto.getId(), dto);
        }
    }
}
