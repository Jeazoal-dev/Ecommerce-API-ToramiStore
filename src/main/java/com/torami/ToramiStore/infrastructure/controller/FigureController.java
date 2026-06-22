package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.products.IFigureService;
import com.torami.ToramiStore.domain.models.products.Figure;
import com.torami.ToramiStore.infrastructure.dto.request.products.CreateFigureRequest;
import com.torami.ToramiStore.infrastructure.dto.response.products.FigureResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.products.FigureResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/figures")
@RequiredArgsConstructor
public class FigureController {

    private final IFigureService figureService;
    private final FigureResponseMapper figureResponseMapper;

    @PostMapping
    public ResponseEntity<FigureResponse> createFigure(@RequestBody CreateFigureRequest request) {

        Figure figure = figureService.createFigure(
                request.getCode(),
                request.getName(),
                request.getPrice(),
                request.getQuantity(),
                request.getCategoryId(),
                request.getLineId(),
                request.getManufacturerId(),
                request.getSerieId()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(figureResponseMapper.toResponse(figure));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FigureResponse> getFigure(@PathVariable Integer id) {
        Figure figure = figureService.getFigureById(id);
        return ResponseEntity.ok(figureResponseMapper.toResponse(figure));
    }
}
