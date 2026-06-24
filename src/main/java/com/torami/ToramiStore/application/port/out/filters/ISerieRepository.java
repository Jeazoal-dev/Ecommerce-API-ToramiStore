package com.torami.ToramiStore.application.port.out.filters;

import com.torami.ToramiStore.domain.models.filters.Serie;

import java.util.List;
import java.util.Optional;

public interface ISerieRepository {

    Optional<Serie> findById(Integer id);

    Serie save(Serie serie);

    List<Serie> findAll();

    void delete(Integer id);
}
