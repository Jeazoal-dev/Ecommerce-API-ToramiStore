package com.torami.ToramiStore.domain.exceptions.filters.Line;

public class LineNotFoundException extends RuntimeException {

    public LineNotFoundException(String message) {
        super(message);
    }

    public LineNotFoundException(Integer id) {
        super("Line with ID " + id + " not found");
    }
}
