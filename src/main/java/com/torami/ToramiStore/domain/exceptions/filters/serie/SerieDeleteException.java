package com.torami.ToramiStore.domain.exceptions.filters.serie;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class SerieDeleteException extends DomainException {

    public SerieDeleteException(Integer serieId, String message, Throwable cause) {
        super("Failed to delete serie with ID " + serieId + ": " + message, "SERIE_DELETE_ERROR", 500, cause);
    }

}