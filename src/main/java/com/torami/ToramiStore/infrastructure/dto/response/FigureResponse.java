package com.torami.ToramiStore.infrastructure.dto.response;

import com.torami.ToramiStore.domain.model.Figure;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FigureResponse {
    private Integer id;
    private Integer code;
    private String name;
    private Double price;
    private Integer quantity;

    public static FigureResponse fromDomain(Figure figure) {
        return new FigureResponse(figure.getId(), figure.getCode(), figure.getName(),
                figure.getPrice(), figure.getQuantity());
    }
}
