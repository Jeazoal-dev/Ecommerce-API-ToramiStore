package com.torami.ToramiStore.infrastructure.persistence.mapper.filters;

import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import com.torami.ToramiStore.infrastructure.persistence.entity.filters.ManufacturerEntity;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerMapper {

    public Manufacturer toDomain(ManufacturerEntity entity) {
        return new Manufacturer(entity.getId(), entity.getName());
    }

    public ManufacturerEntity toEntity(Manufacturer manufacturer) {
        ManufacturerEntity entity = new ManufacturerEntity();
        entity.setId(manufacturer.getId());
        entity.setName(manufacturer.getName());
        return entity;
    }
}
