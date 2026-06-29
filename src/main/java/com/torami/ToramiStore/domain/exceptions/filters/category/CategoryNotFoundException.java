package com.torami.ToramiStore.domain.exceptions.filters.category;

public class CategoryNotFoundException extends RuntimeException {

    private final Integer id;
    private final String errorCode = "CATEGORY_NOT_FOUND";

    public CategoryNotFoundException(Integer id) {
        super("Category with ID " + id + " not found");
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
