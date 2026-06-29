package com.torami.ToramiStore.application.port.out.products;

import com.torami.ToramiStore.domain.models.products.Figure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFigureRepository {
    Figure save(Figure figure);

    Optional<Figure> findById(Integer id);

    Page<Figure> findAll(Pageable pageable);

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
