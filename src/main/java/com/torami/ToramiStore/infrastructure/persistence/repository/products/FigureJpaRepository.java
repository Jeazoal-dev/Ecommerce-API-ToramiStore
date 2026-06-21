package com.torami.ToramiStore.infrastructure.persistence.repository;

import com.torami.ToramiStore.infrastructure.persistence.entity.products.FigureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FigureJpaRepository extends JpaRepository<FigureEntity, Integer> {
}
