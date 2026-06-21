package com.torami.ToramiStore.infrastructure.persistence.mapper.Category;

import com.torami.ToramiStore.domain.models.filters.Category;
import com.torami.ToramiStore.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toDomain(CategoryEntity entity) {
        return new Category(entity.getId(), entity.getName());
    }

    public CategoryEntity toEntity(Category category) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        return entity;
    }
}