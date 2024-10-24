package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.SectorDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {InformeMapper.class})
public interface SectorMapper {

    @Mapping(source = "informe.id", target = "informeId")  // Mapear informe.id a informeId en el DTO
    SectorDTO toSectorDTO(Sector sector);

    @Mapping(source = "informeId", target = "informe.id")  // Mapear informeId del DTO a informe en la entidad
    Sector toSector(SectorDTO sectorDTO);
}
