package com.torami.ToramiStore.domain.models.filters;

import com.torami.ToramiStore.domain.exceptions.filters.serie.SerieInvalidNameException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Serie {
    private Integer id;
    private String name;

    public Serie(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new SerieInvalidNameException(name, "cannot be empty");
        }
        if (name.length() < 3) {
            throw new SerieInvalidNameException(name, "must have at least 3 characters");
        }
        if (name.length() > 100) {
            throw new SerieInvalidNameException(name, "cannot exceed 100 characters");
        }
        this.name = name.trim();
    }

    public Serie(Integer id, String name) {
        this(name);
        this.id = id;
    }
}