package com.torami.ToramiStore.domain.exceptions.filters.serie;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class SerieSaveException extends DomainException {

    public SerieSaveException(Integer serieId, String message, Throwable cause) {
        super("Failed to save serie with ID " + serieId + ": " + message, "SERIE_SAVE_ERROR", 500, cause);
    }

    public SerieSaveException(String name, String message, Throwable cause) {
        super("Failed to save serie with name '" + name + "': " + message, "SERIE_SAVE_ERROR", 500, cause);
    }

}