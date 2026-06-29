package com.torami.ToramiStore.infrastructure.dto.request.filters.line;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLineRequest {

    @NotBlank(message = "Line name cannot be empty")
    @Size(min = 3, max = 100, message = "Line name must be between 3 and 100 characters")
    private String name;

}
