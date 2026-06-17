package com.torami.ToramiStore.infrastructure.persistence.mapper;

import com.torami.ToramiStore.domain.model.Figure;
import com.torami.ToramiStore.infrastructure.persistence.entity.FigureEntity;
import org.springframework.stereotype.Component;

@Component
public class FigureMapper {
    public Figure toDomain(FigureEntity entity){
        return new Figure(
                entity.getId(),
                entity.getCode(),
                entity.getName(),
                entity.getPrice(),
                entity.getQuantity()
        );
    }

    public FigureEntity toEntity(Figure figure){
        FigureEntity entity = new FigureEntity();
        entity.setCode(figure.getCode());
        entity.setName(figure.getName());
        entity.setPrice(figure.getPrice());
        entity.setQuantity(figure.getQuantity());
        return entity;
    }
}
