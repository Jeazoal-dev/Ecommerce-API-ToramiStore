package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Serie;

public interface ISerieService {
    Serie getSerieById(Integer id);
}
