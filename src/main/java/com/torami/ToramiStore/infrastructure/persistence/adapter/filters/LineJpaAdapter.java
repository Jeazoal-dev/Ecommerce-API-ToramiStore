package com.torami.ToramiStore.infrastructure.persistence.adapter.filters;

import com.torami.ToramiStore.application.port.out.filters.ILineRepository;
import com.torami.ToramiStore.domain.models.filters.Line;
import com.torami.ToramiStore.infrastructure.persistence.entity.filters.LineEntity;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.LineMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.filters.LineJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LineJpaAdapter implements ILineRepository {

    private final LineJpaRepository lineJpaRepository;
    private final LineMapper lineMapper;

    @Override
    public Optional<Line> findById(Integer id) {
        return lineJpaRepository.findById(id).map(lineMapper::toDomain);
    }

    @Override
    public List<Line> findAll() {
        return lineJpaRepository.findAll().stream()
                .map(lineMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        lineJpaRepository.deleteById(id);
    }

    @Override
    public Line save(Line line) {
        LineEntity lineEntity = lineMapper.toEntity(line);
        LineEntity saveEntity = lineJpaRepository.save(lineEntity);
        return lineMapper.toDomain(saveEntity);
    }

    @Override
    public boolean existsByName(String name) {
        return lineJpaRepository.existsByName(name);
    }

    @Override
    public Line findByName(String name) {
        return lineJpaRepository.findByName(name)
                .map(lineMapper::toDomain)
                .orElse(null);
    }

    @Override
    public int countFiguresByLineId(Integer lineId) {
        return lineJpaRepository.countFiguresByLineId(lineId);
    }

    @Override
    public long count() {
        return lineJpaRepository.count();
    }
}
