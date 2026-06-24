package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.filters.ISerieService;
import com.torami.ToramiStore.domain.models.filters.Serie;
import com.torami.ToramiStore.infrastructure.dto.request.filters.CreateSerieRequest;
import com.torami.ToramiStore.infrastructure.dto.request.filters.UpdateSerieRequest;
import com.torami.ToramiStore.infrastructure.dto.response.filters.SerieResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.SerieResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Serie")
@RequiredArgsConstructor
public class SerieController {

    private final ISerieService serieService;
    private final SerieResponseMapper serieResponseMapper;

    @GetMapping
    public ResponseEntity<List<SerieResponse>> findAll() {
        List<Serie> serie = serieService.getAllSeries();
        List<SerieResponse> response = serie.stream()
                .map(serieResponseMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieResponse> findById(@PathVariable Integer id) {
        Serie serie = serieService.getSerieById(id);
        SerieResponse response = serieResponseMapper.toResponse(serie);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<SerieResponse> save(@RequestBody CreateSerieRequest request) {
        Serie serie = new Serie(request.getName());
        Serie save = serieService.createSerie(serie);
        SerieResponse response = serieResponseMapper.toResponse(save);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SerieResponse> update(@PathVariable Integer id, @RequestBody UpdateSerieRequest request) {
        Serie serie = new Serie(request.getName());
        Serie save = serieService.updateSerie(id, serie);
        SerieResponse response = serieResponseMapper.toResponse(save);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SerieResponse> delete(@PathVariable Integer id) {
        Serie serie = serieService.getSerieById(id);
        serieService.deleteSerie(id);
        SerieResponse response = serieResponseMapper.toResponse(serie);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
