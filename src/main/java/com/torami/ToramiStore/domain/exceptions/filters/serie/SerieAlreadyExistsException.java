package com.torami.ToramiStore.domain.exceptions.filters.serie;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class SerieAlreadyExistsException extends DomainException {

    public SerieAlreadyExistsException(String name) {
        super("Serie with name '" + name + "' already exists", "SERIE_ALREADY_EXISTS", 400);
    }

}