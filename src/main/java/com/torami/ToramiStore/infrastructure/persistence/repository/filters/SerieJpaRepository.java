package com.torami.ToramiStore.infrastructure.persistence.repository;

import com.torami.ToramiStore.infrastructure.persistence.entity.filters.SerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieJpaRepository extends JpaRepository<SerieEntity, Integer> {
}
