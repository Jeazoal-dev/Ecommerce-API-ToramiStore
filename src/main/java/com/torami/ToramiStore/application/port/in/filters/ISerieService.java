package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Serie;

import java.util.List;

public interface ISerieService {

    Serie createSerie(Serie serie);

    Serie getSerieById(Integer id);

    List<Serie> getAllSeries();

    Serie updateSerie(Integer id, Serie serie);

    void deleteSerie(Integer id);
}
