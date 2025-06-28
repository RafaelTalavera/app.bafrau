package com.axiomasoluciones.app.bafrau.domain.services.user;

import com.axiomasoluciones.app.bafrau.application.dto.user.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<UserDTO> findAll();
    public Optional<UserDTO> findById(Long id);
    public UserDTO createUser(UserDTO userRequestDTO);
    public void deletedById(Long id);
    public UserDTO editedUser(Long id, UserDTO editedUserRequestDTO) ;
    boolean existsByUsername(String username);
    public String extractUserEmailFromToken(String token);
    public Long extractUserIdFromToken(String token);

}
