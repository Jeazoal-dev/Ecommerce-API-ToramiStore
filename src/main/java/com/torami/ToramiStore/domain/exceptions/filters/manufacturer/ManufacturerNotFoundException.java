package com.torami.ToramiStore.domain.exceptions.filters.manufacturer;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class ManufacturerNotFoundException extends DomainException {

    public ManufacturerNotFoundException(Integer id) {
        super("Manufacturer with ID " + id + " not found", "MANUFACTURER_NOT_FOUND", 404);
    }

}