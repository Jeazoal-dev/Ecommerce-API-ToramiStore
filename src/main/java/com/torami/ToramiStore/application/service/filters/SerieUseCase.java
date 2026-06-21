package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.ISerieService;
import com.torami.ToramiStore.application.port.out.filters.ISerieRepository;
import com.torami.ToramiStore.domain.exceptions.filters.SerieNotFoundException;
import com.torami.ToramiStore.domain.models.filters.Serie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SerieUseCase implements ISerieService {

    private final ISerieRepository serieRepository;

    @Override
    public Serie getSerieById(Integer id) {
        return serieRepository.findById(id).orElseThrow(() -> new SerieNotFoundException(id));
    }
}
