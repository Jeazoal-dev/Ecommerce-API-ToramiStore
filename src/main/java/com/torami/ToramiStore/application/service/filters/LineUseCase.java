package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.ILineService;
import com.torami.ToramiStore.application.port.out.filters.ILineRepository;
import com.torami.ToramiStore.domain.exceptions.filters.line.*;
import com.torami.ToramiStore.domain.models.filters.Line;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@AllArgsConstructor
@Validated
public class LineUseCase implements ILineService {

    private final ILineRepository lineRepository;

    @Override
    public Line getLineById(Integer id) {
        try {
            return lineRepository.findById(id)
                    .orElseThrow(() -> new LineNotFoundException(id));
        } catch (LineNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving line with ID " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Line createLine(Line line) {
        try {
            if (lineRepository.existsByName(line.getName())) {
                throw new LineAlreadyExistsException(line.getName());
            }
            return lineRepository.save(line);
        } catch (LineAlreadyExistsException | LineInvalidNameException e) {
            throw e;
        } catch (Exception e) {
            throw new LineSaveException(line.getName(), e.getMessage(), e);
        }
    }

    @Override
    public List<Line> getAllLines() {
        try {
            return lineRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving lines: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Line updateLine(Integer id, Line line) {
        try {
            getLineById(id);
            Line existingByName = lineRepository.findByName(line.getName());
            if (existingByName != null && !existingByName.getId().equals(id)) {
                throw new LineAlreadyExistsException(line.getName());
            }
            Line lineToUpdate = new Line(id, line.getName());
            return lineRepository.save(lineToUpdate);
        } catch (LineNotFoundException | LineAlreadyExistsException | LineInvalidNameException e) {
            throw e;
        } catch (Exception e) {
            throw new LineSaveException(id, e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void deleteLine(Integer id) {
        try {
            getLineById(id);

            int figureCount = lineRepository.countFiguresByLineId(id);
            if (figureCount > 0) {
                throw new LineHasFiguresException(id, figureCount);
            }

            if (lineRepository.count() <= 1) {
                throw new LineCannotBeDeletedException(id, "Cannot delete the only line");
            }

            lineRepository.deleteLine(id);
        } catch (LineNotFoundException | LineHasFiguresException | LineCannotBeDeletedException e) {
            throw e;
        } catch (Exception e) {
            throw new LineDeleteException(id, e.getMessage(), e);
        }
    }

    @Override
    public boolean existsLine(Integer id) {
        return false;
    }

}
