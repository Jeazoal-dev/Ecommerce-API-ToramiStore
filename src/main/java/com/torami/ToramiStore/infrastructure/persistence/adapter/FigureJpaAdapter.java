package com.torami.ToramiStore.infrastructure.persistence.adapter;

import com.torami.ToramiStore.application.port.out.IFigureRepository;
import com.torami.ToramiStore.domain.model.Figure;
import com.torami.ToramiStore.infrastructure.persistence.entity.FigureEntity;
import com.torami.ToramiStore.infrastructure.persistence.mapper.FigureMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.FigureJpaRepository;
import lombok.RequiredArgsConstructor;
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
}
