package com.torami.ToramiStore.infrastructure.persistence.repository;

import com.torami.ToramiStore.infrastructure.persistence.entity.filters.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerJpaRepository extends JpaRepository<ManufacturerEntity, Integer> {
}
