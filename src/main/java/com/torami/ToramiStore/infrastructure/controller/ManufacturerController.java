package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.filters.IManufacturerService;
import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import com.torami.ToramiStore.infrastructure.dto.request.filters.manufacturer.CreateManufacturerRequest;
import com.torami.ToramiStore.infrastructure.dto.request.filters.manufacturer.UpdateManufacturerRequest;
import com.torami.ToramiStore.infrastructure.dto.response.ApiResponse;
import com.torami.ToramiStore.infrastructure.dto.response.filters.ManufacturerResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.ManufacturerResponseMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Manufacturer")
@RequiredArgsConstructor
public class ManufacturerController {

    private final IManufacturerService manufacturerService;
    private final ManufacturerResponseMapper manufacturerResponseMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<ManufacturerResponse>> createManufacturer(
            @Valid @RequestBody CreateManufacturerRequest request,
            HttpServletRequest httpRequest) {

        Manufacturer manufacturer = new Manufacturer(request.getName());
        Manufacturer saved = manufacturerService.createManufacturer(manufacturer);
        ManufacturerResponse data = manufacturerResponseMapper.toResponse(saved);

        ApiResponse<ManufacturerResponse> apiResponse = ApiResponse.created(
                data,
                "Manufacturer created successfully",
                httpRequest.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ManufacturerResponse>>> getAllManufacturers(
            HttpServletRequest request) {

        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        List<ManufacturerResponse> data = manufacturers.stream()
                .map(manufacturerResponseMapper::toResponse)
                .collect(Collectors.toList());

        ApiResponse<List<ManufacturerResponse>> apiResponse = ApiResponse.success(
                data,
                "Manufacturers retrieved successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ManufacturerResponse>> getManufacturerById(
            @PathVariable Integer id,
            HttpServletRequest request) {

        Manufacturer manufacturer = manufacturerService.getManufacturerById(id);
        ManufacturerResponse data = manufacturerResponseMapper.toResponse(manufacturer);

        ApiResponse<ManufacturerResponse> apiResponse = ApiResponse.success(
                data,
                "Manufacturer retrieved successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ManufacturerResponse>> updateManufacturer(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateManufacturerRequest request,
            HttpServletRequest httpRequest) {

        Manufacturer manufacturer = new Manufacturer(request.getName());
        Manufacturer updated = manufacturerService.updateManufacturer(id, manufacturer);
        ManufacturerResponse data = manufacturerResponseMapper.toResponse(updated);

        ApiResponse<ManufacturerResponse> apiResponse = ApiResponse.success(
                data,
                "Manufacturer updated successfully",
                httpRequest.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ManufacturerResponse>> deleteManufacturer(
            @PathVariable Integer id,
            HttpServletRequest request) {

        Manufacturer manufacturer = manufacturerService.getManufacturerById(id);
        manufacturerService.deleteManufacturer(id);
        ManufacturerResponse data = manufacturerResponseMapper.toResponse(manufacturer);

        ApiResponse<ManufacturerResponse> apiResponse = ApiResponse.success(
                data,
                "Manufacturer deleted successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

}
