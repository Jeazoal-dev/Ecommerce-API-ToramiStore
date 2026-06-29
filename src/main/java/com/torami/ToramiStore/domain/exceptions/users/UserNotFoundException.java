package com.torami.ToramiStore.domain.exceptions.users;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class UserNotFoundException extends DomainException {
    public UserNotFoundException(Integer id) {
        super("User with ID " + id + " not found", "USER_NOT_FOUND", 404);
    }

    public UserNotFoundException(String email) {
        super("User with email '" + email + "' not found", "USER_NOT_FOUND", 404);
    }
}
