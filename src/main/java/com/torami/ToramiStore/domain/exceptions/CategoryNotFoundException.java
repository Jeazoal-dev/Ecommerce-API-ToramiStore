package com.torami.ToramiStore.domain.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }

    public CategoryNotFoundException(Integer id) {
        super("Category with ID " + id + " not found");
    }

    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
