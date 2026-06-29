package com.torami.ToramiStore.domain.exceptions.filters.serie;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class SerieCannotBeDeletedException extends DomainException {
    public SerieCannotBeDeletedException(Integer serieId, String reason) {
        super("Serie with ID " + serieId + " cannot be deleted: " + reason, "SERIE_CANNOT_BE_DELETED", 400);
    }
}