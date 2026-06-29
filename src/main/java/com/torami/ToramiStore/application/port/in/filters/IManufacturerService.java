package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface IManufacturerService {

    Manufacturer getManufacturerById(@Min(1) Integer id);

    List<Manufacturer> getAllManufacturers();

    Manufacturer createManufacturer(Manufacturer manufacturer);

    Manufacturer updateManufacturer(@Min(1) Integer id, Manufacturer manufacturer);

    void deleteManufacturer(@Min(1) Integer id);

}
