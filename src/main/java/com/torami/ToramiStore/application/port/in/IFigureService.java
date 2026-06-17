package com.torami.ToramiStore.application.port.in;

import com.torami.ToramiStore.domain.model.Category;
import com.torami.ToramiStore.domain.model.Figure;

public interface IFigureService {
    Figure createFigure(Integer code, String name, Double price, Integer quantity, Integer categoryId);
    Figure getFigureById(Integer id);
}
