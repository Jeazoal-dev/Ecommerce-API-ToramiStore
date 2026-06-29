package com.torami.ToramiStore.domain.models.filters;

import com.torami.ToramiStore.domain.exceptions.filters.manufacturer.ManufacturerInvalidNameException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Manufacturer {
    private Integer id;
    private String name;

    public Manufacturer(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ManufacturerInvalidNameException(name, "cannot be empty");
        }
        if (name.length() < 3) {
            throw new ManufacturerInvalidNameException(name, "must have at least 3 characters");
        }
        if (name.length() > 100) {
            throw new ManufacturerInvalidNameException(name, "cannot exceed 100 characters");
        }
        this.name = name.trim();
    }

    public Manufacturer(Integer id, String name) {
        this(name);
        this.id = id;
    }
}
