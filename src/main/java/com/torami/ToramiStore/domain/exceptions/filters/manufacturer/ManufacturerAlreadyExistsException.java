package com.torami.ToramiStore.domain.exceptions.filters.manufacturer;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class ManufacturerAlreadyExistsException extends DomainException {
    public ManufacturerAlreadyExistsException(String name) {
        super("Manufacturer with name '" + name + "' already exists", "MANUFACTURER_ALREADY_EXISTS", 400);
    }
}