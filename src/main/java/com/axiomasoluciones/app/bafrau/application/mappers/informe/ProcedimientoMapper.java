package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.ProcedimientoDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Procedimiento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {InformeMapper.class})  // Asumiendo que tienes InformeMapper
public interface ProcedimientoMapper {

  //  @Mapping(source = "informe.id", target = "informeId")  // Mapear el ID de informe a informeId en el DTO
    ProcedimientoDTO toProcedimientoDTO(Procedimiento procedimiento);

 //   @Mapping(source = "informeId", target = "informe.id")  // Mapear informeId del DTO a informe en la entidad
    Procedimiento toProcedimiento(ProcedimientoDTO procedimientoDTO);
}
