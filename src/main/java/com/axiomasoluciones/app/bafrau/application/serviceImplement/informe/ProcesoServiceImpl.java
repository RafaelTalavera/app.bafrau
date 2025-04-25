package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ProcesoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.organizacion.ProcesoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Organizacion;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Proceso;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.OrganizacionRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.ProcesoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.ProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProcesoServiceImpl implements ProcesoService {

    @Autowired
    private ProcesoRepository procesoRepository;

    @Autowired
    private OrganizacionRepository organizacionRepository;


    @Autowired
    private ProcesoMapper procesoMapper;

    @Override
    public List<ProcesoDTO> findAll() {
        return StreamSupport.stream(procesoRepository.findAll().spliterator(), false)
                .map(procesoMapper::toProcesoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProcesoDTO findById(Long id) {
        return procesoRepository.findById(id)
                .map(procesoMapper::toProcesoDTO)
                .orElseThrow(() -> new RuntimeException("Proceso no encontrado con ID: " + id));
    }

    @Override
    public ProcesoDTO save(ProcesoDTO procesoDTO) {
        if (procesoDTO.getOrganizacionId() == null) {
            throw new IllegalArgumentException("El ID del informe es obligatorio para crear un proceso.");
        }
        Organizacion organizacion = organizacionRepository.findById(procesoDTO.getOrganizacionId())
                .orElseThrow(() -> new IllegalArgumentException("Informe no encontrado con ID: " + procesoDTO.getOrganizacionId()));
        Proceso proceso = procesoMapper.toProceso(procesoDTO);
        proceso.setOrganizacion(organizacion);
        Proceso savedProceso = procesoRepository.save(proceso);
        return procesoMapper.toProcesoDTO(savedProceso);
    }


    @Override
    public ProcesoDTO update(Long id, ProcesoDTO procesoDTO) {
        Proceso proceso = procesoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proceso no encontrado con ID: " + id));

        proceso.setNombre(procesoDTO.getNombre());
        proceso.setProducto(procesoDTO.getProducto());
        proceso.setSubProducto(procesoDTO.getSubProducto());
        proceso.setResiduos(procesoDTO.getResiduos());
        proceso.setAcopioResiduos(procesoDTO.getAcopioResiduos());
        proceso.setSitioResiduos(procesoDTO.getSitioResiduos());
        proceso.setRecipienteResiduos(procesoDTO.getRecipienteResiduos());

        Proceso updatedProceso = procesoRepository.save(proceso);
        return procesoMapper.toProcesoDTO(updatedProceso);
    }

    @Override
    public void deleteById(Long id) {
        if (!procesoRepository.existsById(id)) {
            throw new RuntimeException("Proceso no encontrado con ID: " + id);
        }
        procesoRepository.deleteById(id);
    }

    @Override
    public List<ProcesoDTO> getProcesoByOrganizacionId(Long organizacionId) {
        List<Proceso> procesos = procesoRepository.findByOrganizacionId(organizacionId);
        return procesos.stream()
                .map(procesoMapper::toProcesoDTO)
                .collect(Collectors.toList());
    }
}