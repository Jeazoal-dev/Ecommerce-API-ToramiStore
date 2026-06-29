package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Line;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface ILineService {

    Line getLineById(Integer id);

    List<Line> getAllLines();

    Line createLine(Line line);

    Line updateLine(@Min(1) Integer id, Line line);

    void deleteLine(@Min(1) Integer id);

}
