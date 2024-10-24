package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.ProcesoDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.ProcesoMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Proceso;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Telefono;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.InformeRepository;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.ProcesoRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.ProcesoService;
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
    private InformeRepository informeRepository;


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
        if (procesoDTO.getInformeId() == null) {
            throw new IllegalArgumentException("El ID del informe es obligatorio para crear un proceso.");
        }

        // Aquí es donde debes buscar el informe relacionado con el informeId
        Informe informe = informeRepository.findById(procesoDTO.getInformeId())
                .orElseThrow(() -> new IllegalArgumentException("Informe no encontrado con ID: " + procesoDTO.getInformeId()));

        Proceso proceso = procesoMapper.toProceso(procesoDTO);
        proceso.setInforme(informe); // Asignar el informe relacionado

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
        proceso.setResiduosLiquidos(procesoDTO.getResiduosLiquidos());
        // Actualizar más campos según sea necesario

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
    public List<ProcesoDTO> getProcesoByInformeId(Long informeId) {
        List<Proceso> procesos = procesoRepository.findByInformeId(informeId);
        return procesos.stream()
                .map(procesoMapper::toProcesoDTO)
                .collect(Collectors.toList());
    }
}