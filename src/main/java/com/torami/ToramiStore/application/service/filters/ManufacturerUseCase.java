package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.IManufacturerService;
import com.torami.ToramiStore.application.port.out.filters.IManufacturerRepository;
import com.torami.ToramiStore.domain.exceptions.filters.ManufacturerNotFoundException;
import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ManufacturerUseCase implements IManufacturerService {

    private final IManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer getManufacturerById(Integer id) {
        return manufacturerRepository.findById(id).orElseThrow(() -> new ManufacturerNotFoundException(id));
    }
}
