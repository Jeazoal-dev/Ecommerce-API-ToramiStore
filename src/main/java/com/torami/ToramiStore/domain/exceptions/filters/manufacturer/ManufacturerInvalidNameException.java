package com.torami.ToramiStore.domain.exceptions.filters.manufacturer;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class ManufacturerInvalidNameException extends DomainException {

    public ManufacturerInvalidNameException(String name, String reason) {
        super("Manufacturer name '" + name + "' is invalid: " + reason, "MANUFACTURER_INVALID_NAME", 400);
    }

}
