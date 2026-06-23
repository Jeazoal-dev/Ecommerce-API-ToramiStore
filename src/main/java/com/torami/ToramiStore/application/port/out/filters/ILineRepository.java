package com.torami.ToramiStore.application.port.out.filters;

import com.torami.ToramiStore.domain.models.filters.Line;

import java.util.List;
import java.util.Optional;

public interface ILineRepository {
    Optional<Line> findById(Integer id);

    List<Line> findAll();

    void deleteLine(Integer id);

    Line save(Line line);

    boolean existsById(Integer id);
}
