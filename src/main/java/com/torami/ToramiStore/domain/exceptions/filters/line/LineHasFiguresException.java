package com.torami.ToramiStore.domain.exceptions.filters.line;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class LineHasFiguresException extends DomainException {
    public LineHasFiguresException(Integer lineId, int figureCount) {
        super("Line with ID " + lineId + " cannot be deleted because it has " + figureCount + " figures associated", "LINE_HAS_FIGURES", 400);
    }
}

