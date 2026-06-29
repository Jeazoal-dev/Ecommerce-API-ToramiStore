package com.torami.ToramiStore.domain.exceptions.filters.manufacturer;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class ManufacturerHasFiguresException extends DomainException {
    public ManufacturerHasFiguresException(Integer manufacturerId, int figureCount) {
        super("Manufacturer with ID " + manufacturerId + " cannot be deleted because it has " + figureCount + " figures associated", "MANUFACTURER_HAS_FIGURES", 400);
    }
}