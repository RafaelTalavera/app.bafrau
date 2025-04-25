package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ProcedimientoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.organizacion.ProcedimientoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Procedimiento;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.OrganizacionRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.ProcedimientoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.ProcedimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcedimientoServiceImpl implements ProcedimientoService {

    @Autowired
    private ProcedimientoRepository procedimientoRepository;

    @Autowired
    private OrganizacionRepository informeRepository;

    @Autowired
    private ProcedimientoMapper procedimientoMapper;

    @Override
    public ProcedimientoDTO createProcedimiento(ProcedimientoDTO procedimientoDTO) {
        Long organizacionId = procedimientoDTO.getOrganizacionId();
        Organizacion organizacion = informeRepository.findById(organizacionId)
                .orElseThrow(() -> new RuntimeException("Organizacion no encontrado con ID: " + organizacionId));

        Procedimiento procedimiento = procedimientoMapper.toProcedimiento(procedimientoDTO);
        procedimiento.setOrganizacion(organizacion);
        Procedimiento savedProcedimiento = procedimientoRepository.save(procedimiento);

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

        existingProcedimiento.setNombre(procedimientoDTO.getNombre());
        existingProcedimiento.setAdjunto(procedimientoDTO.getAdjunto());

        if (procedimientoDTO.getOrganizacionId() != null) {
            Organizacion organizacion = informeRepository.findById(procedimientoDTO.getOrganizacionId())
                    .orElseThrow(() -> new RuntimeException("Organizacion no encontrado con ID: " + procedimientoDTO.getOrganizacionId()));
            existingProcedimiento.setOrganizacion(organizacion);
        }
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
    public List<ProcedimientoDTO> getProcedimientosByOrganizacionId(Long organizacionId) {
        List<Procedimiento> procedimientos = procedimientoRepository.findByOrganizacion_Id(organizacionId);
        return procedimientos.stream()
                .map(procedimientoMapper::toProcedimientoDTO)
                .collect(Collectors.toList());
    }
}