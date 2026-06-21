package com.torami.ToramiStore.infrastructure.persistence.mapper.products;

import com.torami.ToramiStore.domain.models.filters.Category;
import com.torami.ToramiStore.domain.models.filters.Line;
import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import com.torami.ToramiStore.domain.models.filters.Serie;
import com.torami.ToramiStore.domain.models.products.Figure;
import com.torami.ToramiStore.infrastructure.persistence.entity.products.FigureEntity;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.CategoryMapper;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.LineMapper;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.ManufacturerMapper;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.SerieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FigureMapper {

    private final CategoryMapper categoryMapper;
    private final LineMapper lineMapper;
    private final ManufacturerMapper manufacturerMapper;
    private final SerieMapper serieMapper;

    public Figure toDomain(FigureEntity entity) {
        Category category = entity.getCategory() != null ? categoryMapper.toDomain(entity.getCategory()) : null;
        Line line = entity.getLine() != null ? lineMapper.toDomain(entity.getLine()) : null;
        Manufacturer manufacturer = entity.getManufacturer() != null ? manufacturerMapper.toDomain(entity.getManufacturer()) : null;
        Serie serie = entity.getSerie() != null ? serieMapper.toDomain(entity.getSerie()) : null;

        return new Figure(
                entity.getId(),
                entity.getCode(),
                entity.getName(),
                entity.getPrice(),
                entity.getQuantity(),
                category,
                line,
                manufacturer,
                serie
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

        if (figure.getLine() != null) {
            entity.setLine(lineMapper.toEntity(figure.getLine()));
        }

        if (figure.getManufacturer() != null) {
            entity.setManufacturer(manufacturerMapper.toEntity(figure.getManufacturer()));
        }

        if (figure.getSerie() != null) {
            entity.setSerie(serieMapper.toEntity(figure.getSerie()));
        }

        return entity;
    }

}
