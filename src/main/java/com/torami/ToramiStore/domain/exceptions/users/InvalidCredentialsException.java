package com.torami.ToramiStore.domain.exceptions.users;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class InvalidCredentialsException extends DomainException {
    public InvalidCredentialsException() {
        super("Invalid email or password", "INVALID_CREDENTIALS", 401);
    }
}