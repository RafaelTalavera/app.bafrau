package com.axiomasoluciones.app.bafrau.application.mappers.informe;

import com.axiomasoluciones.app.bafrau.application.dto.informe.InformeDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.user.UserMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.informe.Informe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ProcesoMapper.class, ProcedimientoMapper.class})
public interface InformeMapper {

 @Mapping(source = "user.id", target = "userId")
 InformeDTO toInformeDTO(Informe informe);

 @Mapping(source = "userId", target = "user.id")
 Informe toInforme(InformeDTO informeDTO);

 // Ignorar el campo id en la actualización parcial
 @Mapping(target = "id", ignore = true)
 void partialUpdate(InformeDTO source, @MappingTarget Informe target);
}
