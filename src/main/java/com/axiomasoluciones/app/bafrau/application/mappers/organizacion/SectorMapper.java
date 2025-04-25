package com.axiomasoluciones.app.bafrau.application.mappers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.SectorDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrganizacionMapper.class})
public interface SectorMapper {

    @Mapping(source = "organizacion.id", target = "organizacionId")
    SectorDTO toSectorDTO(Sector sector);

    @Mapping(source = "organizacionId", target = "organizacion.id")
    Sector toSector(SectorDTO sectorDTO);
}
