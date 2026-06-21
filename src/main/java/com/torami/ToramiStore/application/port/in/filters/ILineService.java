package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Line;

public interface ILineService {
    Line getLineById(Integer id);
}
