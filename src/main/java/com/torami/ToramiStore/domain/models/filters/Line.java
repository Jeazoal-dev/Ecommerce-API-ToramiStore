package com.torami.ToramiStore.domain.models.filters;

import com.torami.ToramiStore.domain.exceptions.filters.line.LineInvalidNameException;
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
            throw new LineInvalidNameException(name, "cannot be empty");
        }

        if (name.length() < 3) {
            throw new LineInvalidNameException(name, "must have at least 3 characters");
        }

        if (name.length() > 100) {
            throw new LineInvalidNameException(name, "cannot exceed 100 characters");
        }

        this.name = name.trim();
    }
    
}