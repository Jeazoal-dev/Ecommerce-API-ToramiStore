package com.torami.ToramiStore.infrastructure.persistence.adapter.filters;

import com.torami.ToramiStore.application.port.out.filters.ISerieRepository;
import com.torami.ToramiStore.domain.models.filters.Serie;
import com.torami.ToramiStore.infrastructure.persistence.entity.filters.SerieEntity;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.SerieMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.filters.SerieJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SerieJpaAdapter implements ISerieRepository {

    private final SerieJpaRepository jpaRepository;
    private final SerieMapper mapper;

    @Override
    public Optional<Serie> findById(Integer id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Serie save(Serie serie) {
        SerieEntity serieEntity = mapper.toEntity(serie);
        SerieEntity saveEntity = jpaRepository.save(serieEntity);
        return mapper.toDomain(saveEntity);
    }

    @Override
    public List<Serie> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return jpaRepository.existsByName(name);
    }

    @Override
    public Serie findByName(String name) {
        return jpaRepository.findByName(name)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public int countFiguresBySerieId(Integer serieId) {
        return jpaRepository.countFiguresBySerieId(serieId);
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }
}
