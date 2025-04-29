package com.axiomasoluciones.app.bafrau.application.serviceImplement.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.InsumoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.organizacion.InsumoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Insumo;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Proceso;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.InsumoRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.ProcesoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.organizacion.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InsumoServiceImpl implements InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private InsumoMapper insumoMapper;

    @Autowired
    private ProcesoRepository procesoRepository;

    @Override
    public List<InsumoDTO> findAll() {
        return StreamSupport.stream(insumoRepository.findAll().spliterator(), false)
                .map(insumoMapper::toInsumoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InsumoDTO findById(Long id) {
        return insumoRepository.findById(id)
                .map(insumoMapper::toInsumoDTO)
                .orElseThrow(() -> new RuntimeException("Insumo no encontrado con ID: " + id));
    }

    @Override
    public InsumoDTO save(InsumoDTO insumoDTO) {
        // Cargar el Proceso desde la base de datos
        Proceso proceso = procesoRepository.findById(insumoDTO.getProcesoId())
                .orElseThrow(() -> new RuntimeException("Proceso no encontrado con ID: " + insumoDTO.getProcesoId()));

        // Convertir el DTO a entidad
        Insumo insumo = insumoMapper.toInsumo(insumoDTO);

        // Establecer el Proceso en el Insumo
        insumo.setProceso(proceso);

        // Guardar el Insumo en la base de datos
        Insumo savedInsumo = insumoRepository.save(insumo);

        // Convertir la entidad guardada a DTO y retornar
        return insumoMapper.toInsumoDTO(savedInsumo);
    }

    @Override
    public InsumoDTO update(Long id, InsumoDTO insumoDTO) {
        Insumo insumo = insumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo no encontrado con ID: " + id));

        insumo.setNombre(insumoDTO.getNombre());
        insumo.setFichaTecnica(insumoDTO.getFichaTecnica());
        // Actualiza otros campos si es necesario

        Insumo updatedInsumo = insumoRepository.save(insumo);
        return insumoMapper.toInsumoDTO(updatedInsumo);
    }

    @Override
    public void deleteById(Long id) {
        if (!insumoRepository.existsById(id)) {
            throw new RuntimeException("Insumo no encontrado con ID: " + id);
        }
        insumoRepository.deleteById(id);
    }

    @Override
    public List<InsumoDTO> getInsumosByProcesoId(Long procesoId) {
        List<Insumo> insumos = insumoRepository.findByProceso_Id(procesoId);
        return insumos.stream()
                .map(insumoMapper::toInsumoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InsumoDTO> getInsumoByOrganizacionId(Long organizacionId) {
        List<Insumo> insumos = insumoRepository.findByProcesoOrganizacionId(organizacionId);
        return insumos.stream()
                .map(insumoMapper::toInsumoDTO)
                .collect(Collectors.toList());
    }
}