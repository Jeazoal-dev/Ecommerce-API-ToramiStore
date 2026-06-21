package com.torami.ToramiStore.application.port.in;

import com.torami.ToramiStore.domain.models.filters.Line;

public interface ILineService {
    Line getLineById(Integer id);
}
