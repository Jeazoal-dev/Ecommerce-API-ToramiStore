package com.torami.ToramiStore.application.port.out;

import com.torami.ToramiStore.domain.models.filters.Line;

import java.util.Optional;

public interface ILineRepository {
    Optional<Line> findById(Integer id);
}
