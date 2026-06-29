package com.torami.ToramiStore.infrastructure.persistence.mapper.filters;

import com.torami.ToramiStore.domain.models.filters.Line;
import com.torami.ToramiStore.infrastructure.persistence.entity.filters.LineEntity;
import org.springframework.stereotype.Component;

@Component
public class LineMapper {

    public Line toDomain(LineEntity entity) {
        return new Line(entity.getId(), entity.getName());
    }

    public LineEntity toEntity(Line line) {
        LineEntity entity = new LineEntity();
        entity.setId(line.getId());
        entity.setName(line.getName());
        return entity;
    }
}
