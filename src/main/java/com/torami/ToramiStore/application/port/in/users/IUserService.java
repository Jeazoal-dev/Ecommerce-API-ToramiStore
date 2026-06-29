package com.torami.ToramiStore.application.port.in.users;

import com.torami.ToramiStore.domain.models.users.User;

public interface IUserService {

    User register(User user);

    User getByEmail(String email);

    User getById(Integer id);

}
