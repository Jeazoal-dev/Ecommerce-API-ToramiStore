package com.torami.ToramiStore.domain.exceptions.filters.serie;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class SerieInvalidNameException extends DomainException {
    public SerieInvalidNameException(String name, String reason) {
        super("Serie name '" + name + "' is invalid: " + reason, "SERIE_INVALID_NAME", 400);
    }
}