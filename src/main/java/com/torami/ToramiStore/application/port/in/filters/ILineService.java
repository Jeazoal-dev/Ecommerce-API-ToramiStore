package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Line;

import java.util.List;

public interface ILineService {
    Line getLineById(Integer id);

    Line createLine(Line line);

    List<Line> getAllLines();

    Line updateLine(Integer id, Line line);

    void deleteLine(Integer id);

    boolean existsLine(Integer id);
}
