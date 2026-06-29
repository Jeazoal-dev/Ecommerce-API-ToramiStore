package com.torami.ToramiStore.domain.exceptions.filters.manufacturer;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class ManufacturerDeleteException extends DomainException {
    public ManufacturerDeleteException(Integer manufacturerId, String message, Throwable cause) {
        super("Failed to delete manufacturer with ID " + manufacturerId + ": " + message, "MANUFACTURER_DELETE_ERROR", 500, cause);
    }

    public ManufacturerDeleteException(Integer manufacturerId, String message) {
        super("Failed to delete manufacturer with ID " + manufacturerId + ": " + message, "MANUFACTURER_DELETE_ERROR", 500);
    }
}
