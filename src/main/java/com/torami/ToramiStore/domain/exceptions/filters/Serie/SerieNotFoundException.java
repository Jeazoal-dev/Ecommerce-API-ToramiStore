package com.torami.ToramiStore.domain.exceptions.filters.Serie;

public class SerieNotFoundException extends RuntimeException {
    public SerieNotFoundException(String message) {
        super(message);
    }

    public SerieNotFoundException(Integer id) {
        super("Serie with ID " + id + " not found");
    }
}
