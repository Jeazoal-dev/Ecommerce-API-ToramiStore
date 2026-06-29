package com.torami.ToramiStore.domain.exceptions.filters.category;

import com.torami.ToramiStore.domain.exceptions.DomainException;

public class CategoryHasFiguresException extends DomainException {

    public CategoryHasFiguresException(Integer categoryId, int figureCount) {
        super("Category with ID " + categoryId + " cannot be deleted because it has " + figureCount + " figures associated", "CATEGORY_HAS_FIGURES", 400);
    }

}
