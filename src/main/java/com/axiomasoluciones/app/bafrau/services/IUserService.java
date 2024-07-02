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
    public void deletedById(Long id);
    UserResponseDTO editedUser(Long id, UserRequestDTO editedUserRequestDTO);
    boolean existsByUsername(String username);
    public String extractUserEmailFromToken(String token);
    public Long extractUserIdFromToken(String token);

}
