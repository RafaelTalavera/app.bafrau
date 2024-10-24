package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.NominaEmpleadosDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.informe.NominaEmpleadosMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.NominaEmpleados;
import com.axiomasoluciones.app.bafrau.domain.repository.informe.NominaEmpleadosRepository;
import com.axiomasoluciones.app.bafrau.domain.services.informe.NominaEmpleadosService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NominaEmpleadosServiceImpl implements NominaEmpleadosService {

    private final NominaEmpleadosRepository nominaEmpleadosRepository;
    private final NominaEmpleadosMapper nominaEmpleadosMapper;

    public NominaEmpleadosServiceImpl(NominaEmpleadosRepository nominaEmpleadosRepository, NominaEmpleadosMapper nominaEmpleadosMapper) {
        this.nominaEmpleadosRepository = nominaEmpleadosRepository;
        this.nominaEmpleadosMapper = nominaEmpleadosMapper;
    }

    @Override
    public List<NominaEmpleadosDTO> getNominaEmpleadosByInformeId(Long informeId) {
        List<NominaEmpleados> nominaEmpleadosList = nominaEmpleadosRepository.findByInformeId(informeId);
        return nominaEmpleadosList.stream()
                .map(nominaEmpleadosMapper::toNominaEmpleadosDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<NominaEmpleadosDTO> getAllNominaEmpleados() {
        List<NominaEmpleados> nominaEmpleadosList = (List<NominaEmpleados>) nominaEmpleadosRepository.findAll();
        return nominaEmpleadosList.stream()
                .map(nominaEmpleadosMapper::toNominaEmpleadosDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NominaEmpleadosDTO getNominaEmpleadoById(Long id) {
        return nominaEmpleadosRepository.findById(id)
                .map(nominaEmpleadosMapper::toNominaEmpleadosDTO)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @Override
    public NominaEmpleadosDTO createNominaEmpleado(NominaEmpleadosDTO nominaEmpleadosDTO) {
        NominaEmpleados nominaEmpleados = nominaEmpleadosMapper.toNominaEmpleados(nominaEmpleadosDTO);
        NominaEmpleados savedNominaEmpleados = nominaEmpleadosRepository.save(nominaEmpleados);
        return nominaEmpleadosMapper.toNominaEmpleadosDTO(savedNominaEmpleados);
    }

    @Override
    public NominaEmpleadosDTO updateNominaEmpleado(Long id, NominaEmpleadosDTO nominaEmpleadosDTO) {
        NominaEmpleados nominaEmpleados = nominaEmpleadosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        nominaEmpleados.setPuesto(nominaEmpleadosDTO.getPuesto());
        nominaEmpleados.setContrato(nominaEmpleadosDTO.getContrato());
        nominaEmpleados.setCantidad(nominaEmpleadosDTO.getCantidad());

        NominaEmpleados updatedNominaEmpleados = nominaEmpleadosRepository.save(nominaEmpleados);
        return nominaEmpleadosMapper.toNominaEmpleadosDTO(updatedNominaEmpleados);
    }

    @Override
    public void deleteNominaEmpleado(Long id) {
        if (!nominaEmpleadosRepository.existsById(id)) {
            throw new RuntimeException("Empleado no encontrado");
        }
        nominaEmpleadosRepository.deleteById(id);
    }
}
