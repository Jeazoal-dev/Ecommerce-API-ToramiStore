package com.torami.ToramiStore.application.port.in;

import com.torami.ToramiStore.domain.models.filters.Manufacturer;

public interface IManufacturerService {
    Manufacturer getManufacturerById(Integer id);
}
