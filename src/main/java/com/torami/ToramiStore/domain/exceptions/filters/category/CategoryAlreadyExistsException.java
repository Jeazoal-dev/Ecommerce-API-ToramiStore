package com.torami.ToramiStore.domain.exceptions.filters.category;

public class CategoryAlreadyExistsException extends RuntimeException {

    private final String name;
    private final String errorCode = "CATEGORY_ALREADY_EXISTS";

    public CategoryAlreadyExistsException(String name) {
        super("Category with name '" + name + "' already exists");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
