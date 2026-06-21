package com.torami.ToramiStore.infrastructure.persistence.adapter.filters;

import com.torami.ToramiStore.application.port.out.filters.ISerieRepository;
import com.torami.ToramiStore.domain.models.filters.Serie;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.SerieMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.filters.SerieJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SerieJpaAdapter implements ISerieRepository {

    private final SerieJpaRepository serieJpaRepository;
    private final SerieMapper serieMapper;

    @Override
    public Optional<Serie> findById(Integer id) {
        return serieJpaRepository.findById(id).map(serieMapper::toDomain);
    }
}
