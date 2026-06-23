package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.ILineService;
import com.torami.ToramiStore.application.port.out.filters.ILineRepository;
import com.torami.ToramiStore.domain.exceptions.filters.LineNotFoundException;
import com.torami.ToramiStore.domain.models.filters.Line;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LineUseCase implements ILineService {

    private final ILineRepository lineRepository;

    @Override
    public Line getLineById(Integer id) {
        return lineRepository.findById(id).orElseThrow(() -> new LineNotFoundException(id));
    }

    @Override
    public Line createLine(Line line) {
        return lineRepository.save(line);
    }

    @Override
    public List<Line> getAllLines() {
        return lineRepository.findAll();
    }

    @Override
    public Line updateLine(Integer id, Line line) {
        getLineById(id);
        Line lineToUpdate = new Line(line.getId(), line.getName());
        return lineRepository.save(lineToUpdate);
    }

    @Override
    public void deleteLine(Integer id) {
        getLineById(id);
        lineRepository.deleteLine(id);
    }

    @Override
    public boolean existsLine(Integer id) {
        return false;
    }

}
