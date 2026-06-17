package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.IFigureService;
import com.torami.ToramiStore.domain.model.Figure;
import com.torami.ToramiStore.infrastructure.dto.request.CreateFigureRequest;
import com.torami.ToramiStore.infrastructure.dto.response.FigureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ToramiStore/figures")
@RequiredArgsConstructor
public class FigureController {

    private final IFigureService figureService;

    @PostMapping
    public ResponseEntity<FigureResponse> createFigure(@RequestBody CreateFigureRequest request){
        Figure figure = figureService.createFigure(
                request.getCode(),
                request.getName(),
                request.getPrice(),
                request.getQuantity()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(FigureResponse.fromDomain(figure));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FigureResponse>getFigure(@PathVariable Integer id){
        Figure figure = figureService.getFigureById(id);
        return ResponseEntity.ok(FigureResponse.fromDomain(figure));
    }
}
