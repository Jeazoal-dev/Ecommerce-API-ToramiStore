package com.torami.ToramiStore.domain.exceptions.filters.category;

public class CategorySaveException extends RuntimeException {

    private final Integer categoryId;
    private final String name;
    private final String errorCode = "CATEGORY_SAVE_ERROR";

    public CategorySaveException(Integer categoryId, String message, Throwable cause) {
        super("Failed to save category with ID " + categoryId + ": " + message, cause);
        this.categoryId = categoryId;
        this.name = null;
    }

    public CategorySaveException(String name, String message, Throwable cause) {
        super("Failed to save category with name '" + name + "': " + message, cause);
        this.categoryId = null;
        this.name = name;
    }

    public CategorySaveException(String message) {
        super("Failed to save category: " + message);
        this.categoryId = null;
        this.name = null;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

