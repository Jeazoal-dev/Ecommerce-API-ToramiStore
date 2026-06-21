package com.torami.ToramiStore.application.port.in.products;

import com.torami.ToramiStore.domain.models.products.Figure;

public interface IFigureService {
    Figure createFigure(Integer code, String name, Double price, Integer quantity, Integer categoryId, Integer lineId, Integer manufacturerId, Integer serieId);

    Figure getFigureById(Integer id);
}
