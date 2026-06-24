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
    private final ManufacturerJpaRepository manufacturerJpaRepository;
    private final ManufacturerMapper manufacturerMapper;

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        ManufacturerEntity manufacturerEntity = manufacturerMapper.toEntity(manufacturer);
        ManufacturerEntity savedEntity = manufacturerJpaRepository.save(manufacturerEntity);
        return manufacturerMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Manufacturer> findById(Integer id) {
        return manufacturerJpaRepository.findById(id).map(manufacturerMapper::toDomain);
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerJpaRepository.findAll().stream()
                .map(manufacturerMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        manufacturerJpaRepository.deleteById(id);
    }
}
