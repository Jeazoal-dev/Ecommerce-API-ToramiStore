package com.torami.ToramiStore.infrastructure.persistence.mapper.filters;

import com.torami.ToramiStore.domain.models.filters.Category;
import com.torami.ToramiStore.infrastructure.dto.response.filters.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseMapper {

    public CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }
}
