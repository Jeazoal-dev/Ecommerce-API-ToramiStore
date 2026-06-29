package com.torami.ToramiStore.infrastructure.dto.request.filters.manufacturer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateManufacturerRequest {

    @NotBlank(message = "Manufacturer name cannot be empty")
    @Size(min = 3, max = 100, message = "Manufacturer name must be between 3 and 100 characters")
    private String name;
}