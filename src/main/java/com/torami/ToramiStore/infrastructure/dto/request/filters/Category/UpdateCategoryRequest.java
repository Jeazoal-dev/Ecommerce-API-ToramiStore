package com.torami.ToramiStore.infrastructure.dto.request.filters.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryRequest {

    @NotBlank(message = "The name cannot be empty.")
    @Size(min = 3, max = 100, message = "The name must be between 3 and 100 characters.")
    private String name;

}
