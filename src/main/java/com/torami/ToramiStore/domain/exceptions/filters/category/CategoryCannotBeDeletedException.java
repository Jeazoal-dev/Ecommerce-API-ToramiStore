package com.torami.ToramiStore.domain.exceptions.filters.category;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class CategoryCannotBeDeletedException extends DomainException {
    public CategoryCannotBeDeletedException(Integer categoryId, String reason) {
        super("Category with ID " + categoryId + " cannot be deleted: " + reason, "CATEGORY_CANNOT_BE_DELETED", 400);
    }
}
