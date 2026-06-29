package com.torami.ToramiStore.infrastructure.persistence.mapper.filters;

import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import com.torami.ToramiStore.infrastructure.dto.response.filters.ManufacturerResponse;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerResponseMapper {

    public ManufacturerResponse toResponse(Manufacturer manufacturer) {
        return new ManufacturerResponse(
                manufacturer.getId(),
                manufacturer.getName()
        );
    }
}
