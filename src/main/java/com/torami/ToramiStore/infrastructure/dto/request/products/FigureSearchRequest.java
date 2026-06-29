package com.torami.ToramiStore.infrastructure.dto.request.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FigureSearchRequest {

    private String keyword;
    private Integer categoryId;
    private Integer manufacturerId;
    private Integer lineId;
    private Integer serieId;
    private Double minPrice;
    private Double maxPrice;
    private Boolean inStock;

}
