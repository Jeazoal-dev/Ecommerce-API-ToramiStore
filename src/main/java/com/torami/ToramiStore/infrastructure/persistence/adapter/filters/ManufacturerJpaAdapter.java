package com.torami.ToramiStore.infrastructure.persistence.adapter;

import com.torami.ToramiStore.application.port.out.filters.IManufacturerRepository;
import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.ManufacturerMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.ManufacturerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ManufacturerJpaAdapter implements IManufacturerRepository {
    private final ManufacturerJpaRepository manufacturerJpaRepository;
    private final ManufacturerMapper manufacturerMapper;

    @Override
    public Optional<Manufacturer> findById(Integer id) {
        return manufacturerJpaRepository.findById(id).map(manufacturerMapper::toDomain);
    }
}
