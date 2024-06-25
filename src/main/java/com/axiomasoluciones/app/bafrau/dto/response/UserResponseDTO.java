package com.axiomasoluciones.app.bafrau.dto.response;

import com.axiomasoluciones.app.bafrau.models.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private Long id;
    //mail
    private String username;
    private String nombre;
    private String apellido;
    private String password;
    private Role role;

}
