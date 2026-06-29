package com.torami.ToramiStore.domain.exceptions.filters.serie;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class SerieHasFiguresException extends DomainException {
    public SerieHasFiguresException(Integer serieId, int figureCount) {
        super("Serie with ID " + serieId + " cannot be deleted because it has " + figureCount + " figures associated", "SERIE_HAS_FIGURES", 400);
    }
}
