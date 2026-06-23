package com.torami.ToramiStore.infrastructure.persistence.mapper.filters;

import com.torami.ToramiStore.domain.models.filters.Line;
import com.torami.ToramiStore.infrastructure.dto.response.filters.LineResponse;
import org.springframework.stereotype.Component;

@Component
public class LineResponseMapper {
    public LineResponse toResponse(Line line) {
        return new LineResponse(
                line.getId(),
                line.getName()
        );
    }
}
