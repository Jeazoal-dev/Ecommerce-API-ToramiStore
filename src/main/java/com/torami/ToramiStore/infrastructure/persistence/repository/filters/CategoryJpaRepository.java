package com.torami.ToramiStore.infrastructure.persistence.repository.filters;

import com.torami.ToramiStore.infrastructure.persistence.entity.filters.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Integer> {

    boolean existsByName(String name);

    Optional<CategoryEntity> findByName(String name);

    @Query("SELECT COUNT(f) FROM FigureEntity f WHERE f.category.id = :categoryId")
    int countFiguresByCategoryId(@Param("categoryId") Integer categoryId);
}