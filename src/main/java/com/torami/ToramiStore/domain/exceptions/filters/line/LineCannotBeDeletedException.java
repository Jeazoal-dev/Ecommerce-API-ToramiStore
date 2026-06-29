package com.torami.ToramiStore.domain.exceptions.filters.line;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class LineCannotBeDeletedException extends DomainException {

    public LineCannotBeDeletedException(Integer lineId, String reason) {
        super("Line with ID " + lineId + " cannot be deleted: " + reason, "LINE_CANNOT_BE_DELETED", 400);
    }

}
