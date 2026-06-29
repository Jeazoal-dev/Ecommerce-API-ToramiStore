package com.torami.ToramiStore.application.port.out.filters;

import com.torami.ToramiStore.domain.models.filters.Line;

import java.util.List;
import java.util.Optional;

public interface ILineRepository {

    Line save(Line line);

    Optional<Line> findById(Integer id);

    List<Line> findAll();

    void delete(Integer id);

    boolean existsByName(String name);

    Line findByName(String name);

    int countFiguresByLineId(Integer lineId);

    long count();
}
