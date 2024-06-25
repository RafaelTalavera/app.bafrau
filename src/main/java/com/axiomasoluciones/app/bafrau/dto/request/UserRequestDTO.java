package com.axiomasoluciones.app.bafrau.dto.request;

import com.axiomasoluciones.app.bafrau.models.entities.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    @NotNull
    @Size(min = 2, max = 30)
    //mail
    private String username;
    private String nombre;
    private  String apellido;
    private String password;
    @NotNull
    private Role role;


}
