package com.torami.ToramiStore.infrastructure.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFigureRequest {
    private Integer code;
    private String name;
    private Double price;
    private Integer quantity;
    private Integer categoryId;
    private Integer lineId;
    private Integer manufacturerId;
    private Integer serieId;
}
