package com.axiomasoluciones.app.bafrau.application.serviceImplement.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.FactorDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.matriz.FactorMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Factor;

import com.axiomasoluciones.app.bafrau.domain.repository.matriz.FactorRepository;
import com.axiomasoluciones.app.bafrau.domain.services.matriz.IFactorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FactorServiceImpl implements IFactorService {

    private final FactorRepository factorRepository;
    private final FactorMapper factorMapper;

    public FactorServiceImpl(FactorRepository factorRepository, FactorMapper factorMapper) {
        this.factorRepository = factorRepository;
        this.factorMapper = factorMapper;
    }

    @Override
    public List<FactorDTO> findAll() {
        return StreamSupport.stream(factorRepository.findAll().spliterator(), false)
                .map(factorMapper::toFactorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FactorDTO findById(Long id) {
        Factor factor = factorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factor no encontrado con ID: " + id));
        return factorMapper.toFactorDTO(factor);
    }

    @Override
    public FactorDTO save(FactorDTO factorDTO) {
        Factor factor = factorMapper.toFactor(factorDTO);
        return factorMapper.toFactorDTO(factorRepository.save(factor));
    }

    @Override
    public FactorDTO update(Long id, FactorDTO factorDTO) {
        Factor factor = factorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factor no encontrado con ID: " + id));

        factor.setClasificacion(factorDTO.getClasificacion());
        factor.setTipo(factorDTO.getTipo());
        return factorMapper.toFactorDTO(factorRepository.save(factor));
    }

    @Override
    public void delete(Long id) {
        if (!factorRepository.existsById(id)) {
            throw new RuntimeException("Factor no encontrado con ID: " + id);
        }
        factorRepository.deleteById(id);
    }
}
