package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Manufacturer;

import java.util.List;

public interface IManufacturerService {

    Manufacturer createManufacturer(Manufacturer manufacturer);

    Manufacturer getManufacturerById(Integer id);

    List<Manufacturer> getAllManufacturers();

    Manufacturer updateManufacturer(Integer id, Manufacturer manufacturer);

    void deleteManufacturer(Integer id);

}
