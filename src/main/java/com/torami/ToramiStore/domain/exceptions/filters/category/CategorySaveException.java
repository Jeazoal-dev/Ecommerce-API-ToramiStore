package com.torami.ToramiStore.domain.exceptions.filters.category;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class CategorySaveException extends DomainException {

    public CategorySaveException(Integer categoryId, String message, Throwable cause) {
        super("Failed to save category with ID " + categoryId + ": " + message, "CATEGORY_SAVE_ERROR", 500, cause);
    }

    public CategorySaveException(String name, String message, Throwable cause) {
        super("Failed to save category with name '" + name + "': " + message, "CATEGORY_SAVE_ERROR", 500, cause);
    }

}