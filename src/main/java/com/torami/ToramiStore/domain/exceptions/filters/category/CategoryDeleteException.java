package com.torami.ToramiStore.domain.exceptions.filters.category;

public class CategoryDeleteException extends RuntimeException {

    private final Integer categoryId;
    private final String errorCode = "CATEGORY_DELETE_ERROR";

    public CategoryDeleteException(Integer categoryId, String message) {
        super("Failed to delete category with ID " + categoryId + ": " + message);
        this.categoryId = categoryId;
    }

    public CategoryDeleteException(Integer categoryId, String message, Throwable cause) {
        super("Failed to delete category with ID " + categoryId + ": " + message, cause);
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
