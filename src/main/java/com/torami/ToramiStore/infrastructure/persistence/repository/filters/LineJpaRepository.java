package com.torami.ToramiStore.infrastructure.persistence.repository.filters;

import com.torami.ToramiStore.infrastructure.persistence.entity.filters.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LineJpaRepository extends JpaRepository<LineEntity, Integer> {

    boolean existsByName(String name);

    Optional<LineEntity> findByName(String name);

    @Query("SELECT COUNT(f) FROM FigureEntity f WHERE f.line.id = :lineId")
    int countFiguresByLineId(@Param("lineId") Integer lineId);
    
}
