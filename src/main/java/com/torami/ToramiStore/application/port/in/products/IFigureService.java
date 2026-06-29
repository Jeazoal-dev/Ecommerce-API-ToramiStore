package com.torami.ToramiStore.application.port.in.products;

import com.torami.ToramiStore.domain.models.products.Figure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFigureService {
    Figure createFigure(Integer code, String name, Double price, Integer quantity, Integer categoryId, Integer lineId, Integer manufacturerId, Integer serieId);

    Figure getFigureById(Integer id);

    Page<Figure> getAllFigures(Pageable pageable);

    Page<Figure> searchFigures(
            String keyword,
            Integer categoryId,
            Integer manufacturerId,
            Integer lineId,
            Integer serieId,
            Double minPrice,
            Double maxPrice,
            Boolean inStock,
            Pageable pageable
    );

}
