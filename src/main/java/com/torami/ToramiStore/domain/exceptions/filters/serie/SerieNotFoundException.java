package com.torami.ToramiStore.domain.exceptions.filters.serie;

public class SerieNotFoundException extends RuntimeException {
    public SerieNotFoundException(String message) {
        super(message);
    }

    public SerieNotFoundException(Integer id) {
        super("Serie with ID " + id + " not found");
    }
}
