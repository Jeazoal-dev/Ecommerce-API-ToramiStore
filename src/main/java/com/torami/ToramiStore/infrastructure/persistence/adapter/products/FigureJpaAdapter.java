package com.torami.ToramiStore.infrastructure.persistence.adapter.products;

import com.torami.ToramiStore.application.port.out.products.IFigureRepository;
import com.torami.ToramiStore.domain.models.products.Figure;
import com.torami.ToramiStore.infrastructure.persistence.entity.products.FigureEntity;
import com.torami.ToramiStore.infrastructure.persistence.mapper.products.FigureMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.products.FigureJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FigureJpaAdapter implements IFigureRepository {

    private final FigureJpaRepository jpaRepository;
    private final FigureMapper mapper;

    @Override
    public Figure save(Figure figure) {
        FigureEntity entity = mapper.toEntity(figure);
        FigureEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Figure> findById(Integer id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<Figure> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public Page<Figure> searchFigures(String keyword, Integer categoryId, Integer manufacturerId, Integer lineId, Integer serieId, Double minPrice, Double maxPrice, Boolean inStock, Pageable pageable) {
        return jpaRepository.searchFigures(
                keyword,
                categoryId,
                manufacturerId,
                lineId,
                serieId,
                minPrice,
                maxPrice,
                inStock,
                pageable
        ).map(mapper::toDomain);
    }


}
