package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface IManufacturerService {

    Manufacturer createManufacturer(Manufacturer manufacturer);

    List<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerById(@Min(1) Integer id);

    Manufacturer updateManufacturer(@Min(1) Integer id, Manufacturer manufacturer);

    void deleteManufacturer(@Min(1) Integer id);

}
