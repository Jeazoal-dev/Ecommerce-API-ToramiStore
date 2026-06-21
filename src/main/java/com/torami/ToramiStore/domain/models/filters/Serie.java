package com.torami.ToramiStore.domain.models.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Serie {
    private Integer id;
    private String name;

    public Serie(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Serie name cannot be empty");
        }

        this.name = name;
    }

}
