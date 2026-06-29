package com.torami.ToramiStore.domain.exceptions.filters.category;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class CategoryInvalidNameException extends DomainException {
    public CategoryInvalidNameException(String name, String reason) {
        super("Category name '" + name + "' is invalid: " + reason, "CATEGORY_INVALID_NAME", 400);
    }
}
