package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.products.IFigureService;
import com.torami.ToramiStore.domain.models.products.Figure;
import com.torami.ToramiStore.infrastructure.dto.request.products.CreateFigureRequest;
import com.torami.ToramiStore.infrastructure.dto.response.ApiResponse;
import com.torami.ToramiStore.infrastructure.dto.response.products.FigureResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.products.FigureResponseMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public ResponseEntity<ApiResponse<Page<FigureResponse>>> getAllFigures(
            Pageable pageable,
            HttpServletRequest request) {

        Page<Figure> figures = figureService.getAllFigures(pageable);
        Page<FigureResponse> data = figures.map(figureResponseMapper::toResponse);

        ApiResponse<Page<FigureResponse>> apiResponse = ApiResponse.success(
                data,
                "Figures retrieved successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<FigureResponse>>> searchFigures(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer manufacturerId,
            @RequestParam(required = false) Integer lineId,
            @RequestParam(required = false) Integer serieId,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Boolean inStock,
            Pageable pageable,
            HttpServletRequest request) {

        Page<Figure> figures = figureService.searchFigures(
                keyword,
                categoryId,
                manufacturerId,
                lineId,
                serieId,
                minPrice,
                maxPrice,
                inStock,
                pageable
        );

        Page<FigureResponse> data = figures.map(figureResponseMapper::toResponse);

        ApiResponse<Page<FigureResponse>> apiResponse = ApiResponse.success(
                data,
                "Figures retrieved successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

}
