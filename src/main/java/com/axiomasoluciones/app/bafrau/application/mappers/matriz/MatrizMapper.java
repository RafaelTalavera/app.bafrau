package com.axiomasoluciones.app.bafrau.application.mappers.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.MatrizDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.user.UserMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Matriz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = { UserMapper.class, ItemMatrizMapper.class })
public interface MatrizMapper {


    @Mapping(source = "organizacion.id", target = "organizacionId")
    @Mapping(source = "items", target = "items")
    MatrizDTO toMatrizDTO(Matriz matriz);


    @Mapping(source = "organizacionId", target = "organizacion.id")
    @Mapping(source = "items", target = "items")
    Matriz toMatriz(MatrizDTO matrizDTO);
}
