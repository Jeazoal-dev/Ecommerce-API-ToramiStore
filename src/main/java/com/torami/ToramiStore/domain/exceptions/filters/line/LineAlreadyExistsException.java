package com.torami.ToramiStore.domain.exceptions.filters.line;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class LineAlreadyExistsException extends DomainException {
    public LineAlreadyExistsException(String name) {
        super("Line with name '" + name + "' already exists", "LINE_ALREADY_EXISTS", 400);
    }
}