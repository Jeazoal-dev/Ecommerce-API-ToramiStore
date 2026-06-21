package com.torami.ToramiStore.infrastructure.persistence.mapper;

import com.torami.ToramiStore.domain.model.Figure;
import com.torami.ToramiStore.infrastructure.dto.response.CategoryResponse;
import com.torami.ToramiStore.infrastructure.dto.response.FigureResponse;
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
        )
                : null;

        return new FigureResponse(
                figure.getId(),
                figure.getCode(),
                figure.getName(),
                figure.getPrice(),
                figure.getQuantity(),
                categoryResponse
        );
    }
}