package com.torami.ToramiStore.domain.exceptions.filters.category;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class CategoryDeleteException extends DomainException {
    public CategoryDeleteException(Integer categoryId, String message, Throwable cause) {
        super("Failed to delete category with ID " + categoryId + ": " + message, "CATEGORY_DELETE_ERROR", 500, cause);
    }

    public CategoryDeleteException(Integer categoryId, String message) {
        super("Failed to delete category with ID " + categoryId + ": " + message, "CATEGORY_DELETE_ERROR", 500);
    }
}