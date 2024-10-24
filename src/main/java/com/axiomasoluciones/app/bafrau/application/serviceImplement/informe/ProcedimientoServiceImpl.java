package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.ProcedimientoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.ProcedimientoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Procedimiento;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.InformeRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.ProcedimientoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.ProcedimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcedimientoServiceImpl implements ProcedimientoService {

    @Autowired
    private ProcedimientoRepository procedimientoRepository;

    @Autowired
    private InformeRepository informeRepository;

    @Autowired
    private ProcedimientoMapper procedimientoMapper;

    @Override
    public ProcedimientoDTO createProcedimiento(ProcedimientoDTO procedimientoDTO) {
        // Verificar que el Informe existe
        Long informeId = procedimientoDTO.getInformeId();
        Informe informe = informeRepository.findById(informeId)
                .orElseThrow(() -> new RuntimeException("Informe no encontrado con ID: " + informeId));

        // Mapear DTO a entidad
        Procedimiento procedimiento = procedimientoMapper.toProcedimiento(procedimientoDTO);

        // Establecer el Informe en la entidad
        procedimiento.setInforme(informe);

        // Guardar el Procedimiento
        Procedimiento savedProcedimiento = procedimientoRepository.save(procedimiento);

        // Mapear entidad a DTO
        return procedimientoMapper.toProcedimientoDTO(savedProcedimiento);
    }

    @Override
    public ProcedimientoDTO getProcedimientoById(Long id) {
        Procedimiento procedimiento = procedimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procedimiento no encontrado con ID: " + id));
        return procedimientoMapper.toProcedimientoDTO(procedimiento);
    }

    @Override
    public List<ProcedimientoDTO> getAllProcedimientos() {
        List<Procedimiento> procedimientos = (List<Procedimiento>) procedimientoRepository.findAll();
        return procedimientos.stream()
                .map(procedimientoMapper::toProcedimientoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProcedimientoDTO updateProcedimiento(Long id, ProcedimientoDTO procedimientoDTO) {
        Procedimiento existingProcedimiento = procedimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procedimiento no encontrado con ID: " + id));

        // Actualizar campos
        existingProcedimiento.setNombre(procedimientoDTO.getNombre());
        existingProcedimiento.setAdjunto(procedimientoDTO.getAdjunto());

        // Actualizar Informe si se proporciona
        if (procedimientoDTO.getInformeId() != null) {
            Informe informe = informeRepository.findById(procedimientoDTO.getInformeId())
                    .orElseThrow(() -> new RuntimeException("Informe no encontrado con ID: " + procedimientoDTO.getInformeId()));
            existingProcedimiento.setInforme(informe);
        }

        // Guardar cambios
        Procedimiento updatedProcedimiento = procedimientoRepository.save(existingProcedimiento);

        return procedimientoMapper.toProcedimientoDTO(updatedProcedimiento);
    }

    @Override
    public void deleteProcedimientoById(Long id) {
        Procedimiento procedimiento = procedimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procedimiento no encontrado con ID: " + id));
        procedimientoRepository.delete(procedimiento);
    }

    @Override
    public List<ProcedimientoDTO> getProcedimientosByInformeId(Long informeId) {
        List<Procedimiento> procedimientos = procedimientoRepository.findByInforme_Id(informeId);
        return procedimientos.stream()
                .map(procedimientoMapper::toProcedimientoDTO)
                .collect(Collectors.toList());
    }
}