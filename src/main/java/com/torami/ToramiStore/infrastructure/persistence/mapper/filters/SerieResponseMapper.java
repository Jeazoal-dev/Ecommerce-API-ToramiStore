package com.torami.ToramiStore.infrastructure.persistence.mapper.filters;

import com.torami.ToramiStore.domain.models.filters.Serie;
import com.torami.ToramiStore.infrastructure.dto.response.filters.SerieResponse;
import org.springframework.stereotype.Component;

@Component
public class SerieResponseMapper {

    public SerieResponse toResponse(Serie serie) {
        return new SerieResponse(
                serie.getId(),
                serie.getName()
        );
    }
}
