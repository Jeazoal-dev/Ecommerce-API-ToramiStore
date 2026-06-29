package com.torami.ToramiStore.domain.exceptions.users;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class UserAlreadyExistsException extends DomainException {
    public UserAlreadyExistsException(String email) {
        super("User with email '" + email + "' already exists", "USER_ALREADY_EXISTS", 409);
    }
}
