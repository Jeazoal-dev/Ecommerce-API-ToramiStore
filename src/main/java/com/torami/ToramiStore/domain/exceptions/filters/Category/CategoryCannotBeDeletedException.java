package com.torami.ToramiStore.domain.exceptions.filters.Category;

public class CategoryCannotBeDeletedException extends RuntimeException {

    private final Integer categoryId;
    private final String reason;
    private final String errorCode = "CATEGORY_CANNOT_BE_DELETED";

    public CategoryCannotBeDeletedException(Integer categoryId, String reason) {
        super("Category with ID " + categoryId + " cannot be deleted: " + reason);
        this.categoryId = categoryId;
        this.reason = reason;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getReason() {
        return reason;
    }

    public String getErrorCode() {
        return errorCode;
    }
    
}
