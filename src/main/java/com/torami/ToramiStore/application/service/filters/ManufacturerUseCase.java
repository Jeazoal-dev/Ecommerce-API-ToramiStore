package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.IManufacturerService;
import com.torami.ToramiStore.application.port.out.filters.IManufacturerRepository;
import com.torami.ToramiStore.domain.exceptions.filters.Manufacturer.ManufacturerNotFoundException;
import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManufacturerUseCase implements IManufacturerService {

    private final IManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public Manufacturer getManufacturerById(Integer id) {
        return manufacturerRepository.findById(id).orElseThrow(() -> new ManufacturerNotFoundException(id));
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer updateManufacturer(Integer id, Manufacturer manufacturer) {
        getManufacturerById(id);
        Manufacturer manufacturerToUpdate = new Manufacturer(id, manufacturer.getName());
        return manufacturerRepository.save(manufacturerToUpdate);
    }


    @Override
    public void deleteManufacturer(Integer id) {
        getManufacturerById(id);
        manufacturerRepository.delete(id);
    }
}
