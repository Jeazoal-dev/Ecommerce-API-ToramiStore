package com.torami.ToramiStore.infrastructure.persistence.mapper.products;

import com.torami.ToramiStore.domain.models.products.Figure;
import com.torami.ToramiStore.infrastructure.dto.response.filters.CategoryResponse;
import com.torami.ToramiStore.infrastructure.dto.response.filters.LineResponse;
import com.torami.ToramiStore.infrastructure.dto.response.filters.ManufacturerResponse;
import com.torami.ToramiStore.infrastructure.dto.response.filters.SerieResponse;
import com.torami.ToramiStore.infrastructure.dto.response.products.FigureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FigureResponseMapper {


    public FigureResponse toResponse(Figure figure) {

        CategoryResponse categoryResponse = figure.getCategory() != null
                ? new CategoryResponse(
                figure.getCategory().getId(),
                figure.getCategory().getName()
        ) : null;

        LineResponse lineResponse = figure.getLine() != null
                ? new LineResponse(
                figure.getLine().getId(),
                figure.getLine().getName()
        ) : null;

        ManufacturerResponse manufacturerResponse = figure.getManufacturer() != null
                ? new ManufacturerResponse(
                figure.getManufacturer().getId(),
                figure.getManufacturer().getName()
        ) : null;

        SerieResponse serieResponse = figure.getSerie() != null
                ? new SerieResponse(
                figure.getSerie().getId(),
                figure.getSerie().getName()
        ) : null;

        return new FigureResponse(
                figure.getId(),
                figure.getCode(),
                figure.getName(),
                figure.getPrice(),
                figure.getQuantity(),
                categoryResponse,
                lineResponse,
                manufacturerResponse,
                serieResponse
        );
    }
}