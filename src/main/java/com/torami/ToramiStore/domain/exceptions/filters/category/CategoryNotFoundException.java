package com.torami.ToramiStore.domain.exceptions.filters.category;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class CategoryNotFoundException extends DomainException {

    public CategoryNotFoundException(Integer id) {
        super("Category with ID " + id + " not found", "CATEGORY_NOT_FOUND", 404);
    }

}
