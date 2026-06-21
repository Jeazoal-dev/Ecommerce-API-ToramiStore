package com.torami.ToramiStore.domain.models.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {
    private Integer id;
    private String name;

    public Manufacturer(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Manufacturer name cannot be empty");
        }
        this.name = name;
    }

}