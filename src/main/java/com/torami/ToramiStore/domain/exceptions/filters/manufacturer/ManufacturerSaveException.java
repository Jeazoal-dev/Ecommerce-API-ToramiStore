package com.torami.ToramiStore.domain.exceptions.filters.manufacturer;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class ManufacturerSaveException extends DomainException {

    public ManufacturerSaveException(Integer manufacturerId, String message, Throwable cause) {
        super("Failed to save manufacturer with ID " + manufacturerId + ": " + message, "MANUFACTURER_SAVE_ERROR", 500, cause);
    }

    public ManufacturerSaveException(String name, String message, Throwable cause) {
        super("Failed to save manufacturer with name '" + name + "': " + message, "MANUFACTURER_SAVE_ERROR", 500, cause);
    }

    public ManufacturerSaveException(String message) {
        super("Failed to save manufacturer: " + message, "MANUFACTURER_SAVE_ERROR", 500);
    }

}

