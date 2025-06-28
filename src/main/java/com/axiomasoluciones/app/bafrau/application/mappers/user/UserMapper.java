package com.axiomasoluciones.app.bafrau.application.mappers.user;

import com.axiomasoluciones.app.bafrau.application.dto.user.UserDTO;
import com.axiomasoluciones.app.bafrau.domain.entities.user.User;

import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);

    List<UserDTO> toUserDTOs(List<User> users);
}
