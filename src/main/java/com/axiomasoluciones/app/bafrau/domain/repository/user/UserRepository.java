package com.axiomasoluciones.app.bafrau.domain.repository.user;

import com.axiomasoluciones.app.bafrau.domain.entities.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);


}
