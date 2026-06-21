package com.torami.ToramiStore.application.port.in;

import com.torami.ToramiStore.domain.models.filters.Serie;

public interface ISerieService {
    Serie getSerieById(Integer id);
}
