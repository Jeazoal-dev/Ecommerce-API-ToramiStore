package com.torami.ToramiStore.application.port.out;

import com.torami.ToramiStore.domain.models.filters.Serie;

import java.util.Optional;

public interface ISerieRepository {
    Optional<Serie> findById(Integer id);
}
