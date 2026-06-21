package com.torami.ToramiStore.domain.models.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Line {
    private Integer id;
    private String name;

    public Line(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Line name cannot be empty");
        }
        this.name = name;
    }

}