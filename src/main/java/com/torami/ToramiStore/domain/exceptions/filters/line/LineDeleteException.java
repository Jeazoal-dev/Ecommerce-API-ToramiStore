package com.torami.ToramiStore.domain.exceptions.filters.line;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class LineDeleteException extends DomainException {
    public LineDeleteException(Integer lineId, String message, Throwable cause) {
        super("Failed to delete line with ID " + lineId + ": " + message, "LINE_DELETE_ERROR", 500, cause);
    }

    public LineDeleteException(Integer lineId, String message) {
        super("Failed to delete line with ID " + lineId + ": " + message, "LINE_DELETE_ERROR", 500);
    }
}