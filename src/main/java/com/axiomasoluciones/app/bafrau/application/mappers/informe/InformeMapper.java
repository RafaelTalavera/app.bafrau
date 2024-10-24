package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InformeDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.user.UserMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ProcesoMapper.class, ProcedimientoMapper.class})
public interface InformeMapper {

   @Mapping(source = "user.id", target = "userId")  // Mapear el ID del User a userId en el DTO
    InformeDTO toInformeDTO(Informe informe);

    @Mapping(source = "userId", target = "user.id")  // Mapear el userId del DTO al campo User de Informe
    Informe toInforme(InformeDTO informeDTO);
}
