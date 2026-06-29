package com.torami.ToramiStore.infrastructure.persistence.repository.filters;

import com.torami.ToramiStore.infrastructure.persistence.entity.filters.SerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SerieJpaRepository extends JpaRepository<SerieEntity, Integer> {

    boolean existsByName(String name);

    Optional<SerieEntity> findByName(String name);

    @Query("SELECT COUNT(f) FROM FigureEntity f WHERE f.serie.id = :serieId")
    int countFiguresBySerieId(@Param("serieId") Integer serieId);

}
