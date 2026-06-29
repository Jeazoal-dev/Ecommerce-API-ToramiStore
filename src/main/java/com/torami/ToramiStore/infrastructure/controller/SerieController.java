package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.filters.ISerieService;
import com.torami.ToramiStore.domain.models.filters.Serie;
import com.torami.ToramiStore.infrastructure.dto.request.filters.serie.CreateSerieRequest;
import com.torami.ToramiStore.infrastructure.dto.request.filters.serie.UpdateSerieRequest;
import com.torami.ToramiStore.infrastructure.dto.response.ApiResponse;
import com.torami.ToramiStore.infrastructure.dto.response.filters.SerieResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.SerieResponseMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<ApiResponse<SerieResponse>> createSerie(
            @Valid @RequestBody CreateSerieRequest request,
            HttpServletRequest httpRequest) {

        Serie serie = new Serie(request.getName());
        Serie saved = serieService.createSerie(serie);
        SerieResponse data = serieResponseMapper.toResponse(saved);

        ApiResponse<SerieResponse> apiResponse = ApiResponse.created(
                data,
                "Serie created successfully",
                httpRequest.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SerieResponse>>> getAllSeries(
            HttpServletRequest request) {

        List<Serie> series = serieService.getAllSeries();
        List<SerieResponse> data = series.stream()
                .map(serieResponseMapper::toResponse)
                .collect(Collectors.toList());

        ApiResponse<List<SerieResponse>> apiResponse = ApiResponse.success(
                data,
                "Series retrieved successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SerieResponse>> getSerieById(
            @PathVariable Integer id,
            HttpServletRequest request) {

        Serie serie = serieService.getSerieById(id);
        SerieResponse data = serieResponseMapper.toResponse(serie);

        ApiResponse<SerieResponse> apiResponse = ApiResponse.success(
                data,
                "Serie retrieved successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SerieResponse>> updateSerie(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateSerieRequest request,
            HttpServletRequest httpRequest) {

        Serie serie = new Serie(request.getName());
        Serie updated = serieService.updateSerie(id, serie);
        SerieResponse data = serieResponseMapper.toResponse(updated);

        ApiResponse<SerieResponse> apiResponse = ApiResponse.success(
                data,
                "Serie updated successfully",
                httpRequest.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<SerieResponse>> deleteSerie(
            @PathVariable Integer id,
            HttpServletRequest request) {

        Serie serie = serieService.getSerieById(id);
        serieService.deleteSerie(id);
        SerieResponse data = serieResponseMapper.toResponse(serie);

        ApiResponse<SerieResponse> apiResponse = ApiResponse.success(
                data,
                "Serie deleted successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }
}
