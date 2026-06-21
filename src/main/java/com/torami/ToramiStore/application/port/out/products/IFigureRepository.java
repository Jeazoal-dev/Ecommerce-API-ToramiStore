package com.torami.ToramiStore.application.port.out.products;

import com.torami.ToramiStore.domain.models.products.Figure;

import java.util.Optional;

public interface IFigureRepository {
    Figure save(Figure figure);

    Optional<Figure> findById(Integer id);
}
