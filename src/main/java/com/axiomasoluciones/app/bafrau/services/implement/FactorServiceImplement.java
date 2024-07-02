package com.axiomasoluciones.app.bafrau.services.implement;


import com.axiomasoluciones.app.bafrau.dto.request.FactorRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.FactorResponseDTO;
import com.axiomasoluciones.app.bafrau.models.dao.FactorRepository;
import com.axiomasoluciones.app.bafrau.models.entities.Factor;
import com.axiomasoluciones.app.bafrau.services.IFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class FactorServiceImplement implements IFactorService {

    @Autowired
    FactorRepository factorRepository;

    @Override
    public List<FactorResponseDTO> findAll() {
        Iterable<Factor> factores = factorRepository.findAll();
        return StreamSupport.stream(factores.spliterator(),false)
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FactorResponseDTO> findById(Long id) {
        return factorRepository.findById(id).map(this::convertToResponseDTO);
    }

    @Override
    public FactorResponseDTO createFactor(FactorRequestDTO factorRequestDTO) {

        Factor newFactor = new Factor(
                factorRequestDTO.getClasificacion(), factorRequestDTO.getTipo()
        );

        Factor savedFactor = factorRepository.save(newFactor);

        return new FactorResponseDTO(
                savedFactor.getId(),
                savedFactor.getClasificacion(),
                savedFactor.getTipo()
        );
    }

    @Override
    public void deleteById(Long id) {
        factorRepository.deleteById(id);

    }

    @Override
    public FactorResponseDTO editedUser(Long id, FactorRequestDTO editedFactorRequestDTO) {
        Optional<Factor> optionalFactor = factorRepository.findById(id);
        if(optionalFactor.isPresent()){
            Factor factor = optionalFactor.get();
            factor.setClasificacion(editedFactorRequestDTO.getClasificacion());
            factor.setTipo(editedFactorRequestDTO.getTipo());
            Factor updateFactor = factorRepository.save(factor);
            return convertToResponseDTO(updateFactor);
        }
        return null;
    }

    @Override
    public List<FactorResponseDTO> findByClasificacion(String clasificacion) {
        Iterable<Factor> factores = factorRepository.findByClasificacion(clasificacion);
        return StreamSupport.stream(factores.spliterator(),false)
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private FactorResponseDTO convertToResponseDTO(Factor factor){
        FactorResponseDTO dto = new FactorResponseDTO();
        dto.setId(factor.getId());
        dto.setClasificacion(factor.getClasificacion());
        dto.setTipo(factor.getTipo());

        return dto;
    }


}
