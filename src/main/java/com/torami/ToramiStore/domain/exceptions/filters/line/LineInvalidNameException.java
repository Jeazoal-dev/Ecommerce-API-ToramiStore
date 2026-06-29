package com.torami.ToramiStore.domain.exceptions.filters.line;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class LineInvalidNameException extends DomainException {

    public LineInvalidNameException(String name, String reason) {
        super("Line name '" + name + "' is invalid: " + reason, "LINE_INVALID_NAME", 400);
    }

}