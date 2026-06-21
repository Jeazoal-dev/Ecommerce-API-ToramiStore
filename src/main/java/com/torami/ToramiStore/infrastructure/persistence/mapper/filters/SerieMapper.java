package com.torami.ToramiStore.infrastructure.persistence.mapper.filters;

import com.torami.ToramiStore.domain.models.filters.Serie;
import com.torami.ToramiStore.infrastructure.persistence.entity.filters.SerieEntity;
import org.springframework.stereotype.Component;

@Component
public class SerieMapper {

    public Serie toDomain(SerieEntity entity) {
        return new Serie(entity.getId(), entity.getName());
    }

    public SerieEntity toEntity(Serie serie) {
        SerieEntity entity = new SerieEntity();
        entity.setId(serie.getId());
        entity.setName(serie.getName());
        return entity;
    }
}
