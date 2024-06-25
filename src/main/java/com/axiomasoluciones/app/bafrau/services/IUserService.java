package com.axiomasoluciones.app.bafrau.services;

import com.axiomasoluciones.app.bafrau.dto.request.UserRequestDTO;
import com.axiomasoluciones.app.bafrau.dto.response.UserResponseDTO;
import com.axiomasoluciones.app.bafrau.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<UserResponseDTO> findAll();

    Optional<UserResponseDTO> findById(Long id);

    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    public void delete(User user);

    UserResponseDTO editedUser(Long id, UserRequestDTO editedUserRequestDTO);

    boolean existsByUsername(String username);

    public String extractUserEmailFromToken(String token);

}
