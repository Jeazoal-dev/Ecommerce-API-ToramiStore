package com.torami.ToramiStore.domain.exceptions.filters.manufacturer;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class ManufacturerCannotBeDeletedException extends DomainException {
    public ManufacturerCannotBeDeletedException(Integer manufacturerId, String reason) {
        super("Manufacturer with ID " + manufacturerId + " cannot be deleted: " + reason, "MANUFACTURER_CANNOT_BE_DELETED", 400);
    }
}
