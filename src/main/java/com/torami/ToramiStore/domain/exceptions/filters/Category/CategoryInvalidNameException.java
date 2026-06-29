package com.torami.ToramiStore.domain.exceptions.filters.Category;

public class CategoryInvalidNameException extends RuntimeException {

    private final String name;
    private final String reason;
    private final String errorCode = "CATEGORY_INVALID_NAME";

    public CategoryInvalidNameException(String name, String reason) {
        super("Category name '" + name + "' is invalid: " + reason);
        this.name = name;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public String getReason() {
        return reason;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
