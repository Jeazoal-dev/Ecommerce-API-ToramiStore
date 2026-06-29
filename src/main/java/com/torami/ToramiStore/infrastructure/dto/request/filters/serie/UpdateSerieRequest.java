package com.torami.ToramiStore.infrastructure.dto.request.filters.serie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSerieRequest {

    @NotBlank(message = "Serie name cannot be empty")
    @Size(min = 3, max = 100, message = "Serie name must be between 3 and 100 characters")
    private String name;
}
