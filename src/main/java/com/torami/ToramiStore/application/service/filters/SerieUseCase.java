package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.ISerieService;
import com.torami.ToramiStore.application.port.out.filters.ISerieRepository;
import com.torami.ToramiStore.domain.exceptions.filters.serie.SerieNotFoundException;
import com.torami.ToramiStore.domain.models.filters.Serie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SerieUseCase implements ISerieService {

    private final ISerieRepository serieRepository;

    @Override
    public Serie createSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public Serie getSerieById(Integer id) {
        return serieRepository.findById(id).orElseThrow(() -> new SerieNotFoundException(id));
    }

    @Override
    public List<Serie> getAllSeries() {
        return serieRepository.findAll();
    }

    @Override
    public Serie updateSerie(Integer id, Serie serie) {
        getSerieById(id);
        Serie updatedSerie = new Serie(id, serie.getName());
        return serieRepository.save(updatedSerie);
    }

    @Override
    public void deleteSerie(Integer id) {
        getSerieById(id);
        serieRepository.delete(id);
    }
}
