package com.torami.ToramiStore.application.port.out;

import com.torami.ToramiStore.domain.models.filters.Manufacturer;

import java.util.Optional;

public interface IManufacturerRepository {
    Optional<Manufacturer> findById(Integer id);
}
