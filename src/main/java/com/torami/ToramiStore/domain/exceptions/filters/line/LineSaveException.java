package com.torami.ToramiStore.domain.exceptions.filters.line;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class LineSaveException extends DomainException {
    public LineSaveException(Integer lineId, String message, Throwable cause) {
        super("Failed to save line with ID " + lineId + ": " + message, "LINE_SAVE_ERROR", 500, cause);
    }

    public LineSaveException(String name, String message, Throwable cause) {
        super("Failed to save line with name '" + name + "': " + message, "LINE_SAVE_ERROR", 500, cause);
    }

}