package com.torami.ToramiStore.infrastructure.persistence.repository;

import com.torami.ToramiStore.infrastructure.persistence.entity.filters.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Integer> {
}