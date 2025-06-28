package com.axiomasoluciones.app.bafrau.application.mappers.organizacion;

import com.axiomasoluciones.app.bafrau.application.dto.organizacion.ProcedimientoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.organizacion.Procedimiento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrganizacionMapper.class})
public interface ProcedimientoMapper {

  //  @Mapping(source = "organizacion.id", target = "organizacionId")
    ProcedimientoDTO toProcedimientoDTO(Procedimiento procedimiento);

 //   @Mapping(source = "organizacionId", target = "organizacion.id")
    Procedimiento toProcedimiento(ProcedimientoDTO procedimientoDTO);
}
