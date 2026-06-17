package com.torami.ToramiStore.application.port.out;

import com.torami.ToramiStore.domain.model.Figure;
import java.util.Optional;

public interface IFigureRepository {
    Figure save(Figure figure);
    Optional<Figure> findById(Integer id);
}
