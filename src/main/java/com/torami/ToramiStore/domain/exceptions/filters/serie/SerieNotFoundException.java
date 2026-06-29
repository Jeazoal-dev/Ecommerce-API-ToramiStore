package com.torami.ToramiStore.domain.exceptions.filters.serie;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class SerieNotFoundException extends DomainException {

    public SerieNotFoundException(Integer id) {
        super("Serie with ID " + id + " not found", "SERIE_NOT_FOUND", 404);
    }

}