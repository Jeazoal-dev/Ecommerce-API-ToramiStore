package com.torami.ToramiStore.application.port.out.users;

import com.torami.ToramiStore.domain.models.users.User;

import java.util.Optional;

public interface IUserRepository {

    User save(User user);

    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
