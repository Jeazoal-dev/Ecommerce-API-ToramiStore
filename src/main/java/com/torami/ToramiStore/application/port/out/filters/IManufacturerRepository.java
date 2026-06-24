package com.torami.ToramiStore.application.port.out.filters;

import com.torami.ToramiStore.domain.models.filters.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface IManufacturerRepository {

    Manufacturer save(Manufacturer manufacturer);

    Optional<Manufacturer> findById(Integer id);

    List<Manufacturer> findAll();

    void delete(Integer id);
}
