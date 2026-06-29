package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.IManufacturerService;
import com.torami.ToramiStore.application.port.out.filters.IManufacturerRepository;
import com.torami.ToramiStore.domain.exceptions.filters.manufacturer.*;
import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManufacturerUseCase implements IManufacturerService {
    private final IManufacturerRepository manufacturerRepository;

    @Override
    @Transactional
    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        try {
            if (manufacturerRepository.existsByName(manufacturer.getName())) {
                throw new ManufacturerAlreadyExistsException(manufacturer.getName());
            }
            return manufacturerRepository.save(manufacturer);
        } catch (ManufacturerAlreadyExistsException | ManufacturerInvalidNameException e) {
            throw e;
        } catch (Exception e) {
            throw new ManufacturerSaveException(manufacturer.getName(), e.getMessage(), e);
        }
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        try {
            return manufacturerRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving manufacturers: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Manufacturer updateManufacturer(Integer id, Manufacturer manufacturer) {
        try {
            getManufacturerById(id);
            Manufacturer existingByName = manufacturerRepository.findByName(manufacturer.getName());
            if (existingByName != null && !existingByName.getId().equals(id)) {
                throw new ManufacturerAlreadyExistsException(manufacturer.getName());
            }
            Manufacturer manufacturerToUpdate = new Manufacturer(id, manufacturer.getName());
            return manufacturerRepository.save(manufacturerToUpdate);
        } catch (ManufacturerNotFoundException | ManufacturerAlreadyExistsException |
                 ManufacturerInvalidNameException e) {
            throw e;
        } catch (Exception e) {
            throw new ManufacturerSaveException(id, e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void deleteManufacturer(Integer id) {
        try {
            getManufacturerById(id);

            int figureCount = manufacturerRepository.countFiguresByManufacturerId(id);
            if (figureCount > 0) {
                throw new ManufacturerHasFiguresException(id, figureCount);
            }

            if (manufacturerRepository.count() <= 1) {
                throw new ManufacturerCannotBeDeletedException(id, "Cannot delete the only manufacturer");
            }

            manufacturerRepository.delete(id);
        } catch (ManufacturerNotFoundException | ManufacturerHasFiguresException |
                 ManufacturerCannotBeDeletedException e) {
            throw e;
        } catch (Exception e) {
            throw new ManufacturerDeleteException(id, e.getMessage(), e);
        }
    }

    @Override
    public Manufacturer getManufacturerById(Integer id) {
        try {
            return manufacturerRepository.findById(id)
                    .orElseThrow(() -> new ManufacturerNotFoundException(id));
        } catch (ManufacturerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving manufacturer with ID " + id + ": " + e.getMessage(), e);
        }
    }
}
