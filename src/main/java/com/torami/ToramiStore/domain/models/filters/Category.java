package com.torami.ToramiStore.domain.models.filters;

import com.torami.ToramiStore.domain.exceptions.filters.Category.CategoryInvalidNameException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Integer id;
    private String name;

    public Category(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new CategoryInvalidNameException("name", "Category name cannot be empty");
        }
        if (name.length() < 3) {
            throw new CategoryInvalidNameException("name", "Category name must have at least 3 characters");
        }
        if (name.length() > 100) {
            throw new CategoryInvalidNameException("name", "Category name cannot exceed 100 characters");
        }

        this.name = name;
    }
}