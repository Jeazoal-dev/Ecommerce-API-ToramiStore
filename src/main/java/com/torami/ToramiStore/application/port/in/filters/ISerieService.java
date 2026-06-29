package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Serie;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface ISerieService {

    Serie getSerieById(@Min(1) Integer id);

    List<Serie> getAllSeries();

    Serie createSerie(Serie serie);

    Serie updateSerie(@Min(1) Integer id, Serie serie);

    void deleteSerie(@Min(1) Integer id);
}
