package com.torami.ToramiStore.domain.exceptions.filters.category;

public class CategoryHasFiguresException extends RuntimeException {

    private final Integer categoryId;
    private final int figureCount;
    private final String errorCode = "CATEGORY_HAS_FIGURES";

    public CategoryHasFiguresException(Integer categoryId, int figureCount) {
        super("Category with ID " + categoryId + " cannot be deleted because it has " + figureCount + " figures associated");
        this.categoryId = categoryId;
        this.figureCount = figureCount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public int getFigureCount() {
        return figureCount;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
