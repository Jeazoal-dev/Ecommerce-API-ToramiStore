package com.torami.ToramiStore.domain.exceptions.filters.line;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class LineNotFoundException extends DomainException {

    public LineNotFoundException(Integer id) {
        super("Line with ID " + id + " not found", "LINE_NOT_FOUND", 404);
    }

}
