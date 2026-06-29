package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Line;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface ILineService {
    Line getLineById(Integer id);

    Line createLine(Line line);

    List<Line> getAllLines();

    Line updateLine(@Min(1) Integer id, Line line);

    void deleteLine(@Min(1) Integer id);

    boolean existsLine(@Min(1) Integer id);
}
