package com.torami.ToramiStore.infrastructure.persistence.mapper.Figure;

import com.torami.ToramiStore.domain.models.filters.Category;
import com.torami.ToramiStore.domain.models.products.Figure;
import com.torami.ToramiStore.infrastructure.persistence.entity.FigureEntity;
import com.torami.ToramiStore.infrastructure.persistence.mapper.Category.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FigureMapper {
    private final CategoryMapper categoryMapper;

    public Figure toDomain(FigureEntity entity) {
        Category category = entity.getCategory() != null
                ? categoryMapper.toDomain(entity.getCategory())
                : null;
        return new Figure(
                entity.getId(),
                entity.getCode(),
                entity.getName(),
                entity.getPrice(),
                entity.getQuantity(),
                category
        );
    }

    public FigureEntity toEntity(Figure figure) {
        FigureEntity entity = new FigureEntity();
        entity.setCode(figure.getCode());
        entity.setName(figure.getName());
        entity.setPrice(figure.getPrice());
        entity.setQuantity(figure.getQuantity());

        if (figure.getCategory() != null) {
            entity.setCategory(categoryMapper.toEntity(figure.getCategory()));
        }

        return entity;
    }

}
