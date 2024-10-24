package com.axiomasoluciones.app.bafrau.application.mappers.matriz;

import com.axiomasoluciones.app.bafrau.application.dto.matriz.MatrizDTO;
import com.axiomasoluciones.app.bafrau.application.mappers.seccion.SeccionMapper;
import com.axiomasoluciones.app.bafrau.application.mappers.user.UserMapper;
import com.axiomasoluciones.app.bafrau.domain.entities.matriz.Matriz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {UserMapper.class, SeccionMapper.class, ItemMatrizMapper.class})
public interface MatrizMapper {

    @Mappings({
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "seccion.id", target = "seccionId"),
            @Mapping(source = "items", target = "items")  // La lista de items usa ItemMatrizMapper
    })
    MatrizDTO toMatrizDTO(Matriz matriz);

    @Mappings({
            @Mapping(source = "userId", target = "user.id"),
            @Mapping(source = "seccionId", target = "seccion.id"),
            @Mapping(source = "items", target = "items")  // Mapear la lista de items
    })
    Matriz toMatriz(MatrizDTO matrizDTO);
}
