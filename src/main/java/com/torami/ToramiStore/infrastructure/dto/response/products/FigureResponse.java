package com.torami.ToramiStore.infrastructure.dto.response.products;

import com.torami.ToramiStore.infrastructure.dto.response.filters.CategoryResponse;
import com.torami.ToramiStore.infrastructure.dto.response.filters.LineResponse;
import com.torami.ToramiStore.infrastructure.dto.response.filters.ManufacturerResponse;
import com.torami.ToramiStore.infrastructure.dto.response.filters.SerieResponse;
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
    private CategoryResponse category;
    private LineResponse line;
    private ManufacturerResponse manufacturer;
    private SerieResponse serie;
}