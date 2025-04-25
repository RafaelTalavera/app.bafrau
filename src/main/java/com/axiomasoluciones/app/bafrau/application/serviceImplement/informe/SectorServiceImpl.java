package com.axiomasoluciones.app.bafrau.application.serviceImplement.informe;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.SectorDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.organizacion.SectorMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Sector;
import com.axiomasoluciones.app.bafrau.domain.repository.organizacion.SectorRepository;

import com.axiomasoluciones.app.bafrau.domain.services.organizacion.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SectorServiceImpl implements SectorService {

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private SectorMapper sectorMapper;

    @Override
    public List<SectorDTO> findAll() {
        return StreamSupport.stream(sectorRepository.findAll().spliterator(), false)
                .map(sectorMapper::toSectorDTO)
                .collect(Collectors.toList());
    }


    @Override
    public SectorDTO findById(Long id) {
        return sectorRepository.findById(id)
                .map(sectorMapper::toSectorDTO)
                .orElseThrow(() -> new RuntimeException("Sector no encontrado con ID: " + id));
    }

    @Override
    public SectorDTO save(SectorDTO sectorDTO) {
        Sector sector = sectorMapper.toSector(sectorDTO);
        Sector savedSector = sectorRepository.save(sector);
        return sectorMapper.toSectorDTO(savedSector);
    }

    @Override
    public SectorDTO update(Long id, SectorDTO sectorDTO) {
        Sector sector = sectorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sector no encontrado con ID: " + id));

        sector.setSector(sectorDTO.getSector());
        sector.setM2(sectorDTO.getM2());
        // Se puede actualizar cualquier otro campo necesario

        Sector updatedSector = sectorRepository.save(sector);
        return sectorMapper.toSectorDTO(updatedSector);
    }

    @Override
    public void deleteById(Long id) {
        if (!sectorRepository.existsById(id)) {
            throw new RuntimeException("Sector no encontrado con ID: " + id);
        }
        sectorRepository.deleteById(id);
    }

    @Override
    public List<SectorDTO> getSectorByOrganizacionId(Long organizacionId) {
        List<Sector> sectores = sectorRepository.findByOrganizacionId(organizacionId);
        return sectores.stream()
                .map(sectorMapper::toSectorDTO)  // Mapea a SectorDTO
                .collect(Collectors.toList());
    }

}