package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.ISerieService;
import com.torami.ToramiStore.application.port.out.filters.ISerieRepository;
import com.torami.ToramiStore.domain.exceptions.filters.serie.*;
import com.torami.ToramiStore.domain.models.filters.Serie;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class SerieUseCase implements ISerieService {

    private final ISerieRepository serieRepository;

    @Override
    @Transactional
    public Serie createSerie(Serie serie) {
        try {
            if (serieRepository.existsByName(serie.getName())) {
                throw new SerieAlreadyExistsException(serie.getName());
            }
            return serieRepository.save(serie);
        } catch (SerieAlreadyExistsException | SerieInvalidNameException e) {
            throw e;
        } catch (Exception e) {
            throw new SerieSaveException(serie.getName(), e.getMessage(), e);
        }
    }

    @Override
    public List<Serie> getAllSeries() {
        try {
            return serieRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving series: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Serie updateSerie(Integer id, Serie serie) {
        try {
            getSerieById(id);
            Serie existingByName = serieRepository.findByName(serie.getName());
            if (existingByName != null && !existingByName.getId().equals(id)) {
                throw new SerieAlreadyExistsException(serie.getName());
            }
            Serie serieToUpdate = new Serie(id, serie.getName());
            return serieRepository.save(serieToUpdate);
        } catch (SerieNotFoundException | SerieAlreadyExistsException | SerieInvalidNameException e) {
            throw e;
        } catch (Exception e) {
            throw new SerieSaveException(id, e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void deleteSerie(Integer id) {
        try {
            getSerieById(id);

            int figureCount = serieRepository.countFiguresBySerieId(id);
            if (figureCount > 0) {
                throw new SerieHasFiguresException(id, figureCount);
            }

            if (serieRepository.count() <= 1) {
                throw new SerieCannotBeDeletedException(id, "Cannot delete the only serie");
            }

            serieRepository.delete(id);
        } catch (SerieNotFoundException | SerieHasFiguresException | SerieCannotBeDeletedException e) {
            throw e;
        } catch (Exception e) {
            throw new SerieDeleteException(id, e.getMessage(), e);
        }
    }

    @Override
    public Serie getSerieById(Integer id) {
        try {
            return serieRepository.findById(id)
                    .orElseThrow(() -> new SerieNotFoundException(id));
        } catch (SerieNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving serie with ID " + id + ": " + e.getMessage(), e);
        }
    }
}

