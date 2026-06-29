package com.torami.ToramiStore.domain.exceptions.filters.category;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class CategoryAlreadyExistsException extends DomainException {

    public CategoryAlreadyExistsException(String name) {
        super("Category with name '" + name + "' already exists", "CATEGORY_ALREADY_EXISTS", 400);
    }

}
