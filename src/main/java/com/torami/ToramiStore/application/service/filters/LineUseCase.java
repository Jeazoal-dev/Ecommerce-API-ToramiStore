package com.torami.ToramiStore.application.service;

import com.torami.ToramiStore.application.port.in.ILineService;
import com.torami.ToramiStore.application.port.out.ILineRepository;
import com.torami.ToramiStore.domain.exceptions.LineNotFoundException;
import com.torami.ToramiStore.domain.models.filters.Line;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LineUseCase implements ILineService {

    private final ILineRepository lineRepository;

    @Override
    public Line getLineById(Integer id) {
        return lineRepository.findById(id).orElseThrow(() -> new LineNotFoundException(id));
    }

}
