package com.torami.ToramiStore.domain.exceptions.filters.Manufacturer;

public class ManufacturerNotFoundException extends RuntimeException {

    public ManufacturerNotFoundException(String message) {
        super(message);
    }

    public ManufacturerNotFoundException(Integer id) {
        super("Manufacturer with ID " + id + " not found");
    }
}
