package com.torami.ToramiStore.infrastructure.persistence.adapter.filters;

import com.torami.ToramiStore.application.port.out.filters.IManufacturerRepository;
import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import com.torami.ToramiStore.infrastructure.persistence.entity.filters.ManufacturerEntity;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.ManufacturerMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.filters.ManufacturerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ManufacturerJpaAdapter implements IManufacturerRepository {

    private final ManufacturerJpaRepository jpaRepository;
    private final ManufacturerMapper mapper;

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        ManufacturerEntity manufacturerEntity = mapper.toEntity(manufacturer);
        ManufacturerEntity savedEntity = jpaRepository.save(manufacturerEntity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Manufacturer> findById(Integer id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Manufacturer> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return jpaRepository.existsByName(name);
    }

    @Override
    public Manufacturer findByName(String name) {
        return jpaRepository.findByName(name)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public int countFiguresByManufacturerId(Integer manufacturerId) {
        return jpaRepository.countFiguresByManufacturerId(manufacturerId);
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }
}
