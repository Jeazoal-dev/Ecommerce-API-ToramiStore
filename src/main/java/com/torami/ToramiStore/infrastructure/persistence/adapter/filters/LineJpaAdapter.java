package com.torami.ToramiStore.infrastructure.persistence.adapter;

import com.torami.ToramiStore.application.port.out.filters.ILineRepository;
import com.torami.ToramiStore.domain.models.filters.Line;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.LineMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.LineJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LineJpaAdapter implements ILineRepository {

    private final LineJpaRepository lineJpaRepository;
    private final LineMapper lineMapper;

    @Override
    public Optional<Line> findById(Integer id) {
        return lineJpaRepository.findById(id).map(lineMapper::toDomain);
    }
}
