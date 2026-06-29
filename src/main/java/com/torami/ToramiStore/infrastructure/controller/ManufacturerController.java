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
@RequestMapping("/manufacturer")
@RequiredArgsConstructor
public class ManufacturerController {

    private final IManufacturerService service;
    private final ManufacturerResponseMapper responseMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<ManufacturerResponse>> createManufacturer(
            @Valid @RequestBody CreateManufacturerRequest request,
            HttpServletRequest httpRequest) {

        Manufacturer manufacturer = new Manufacturer(request.getName());
        Manufacturer saved = service.createManufacturer(manufacturer);
        ManufacturerResponse data = responseMapper.toResponse(saved);

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

        List<Manufacturer> manufacturers = service.getAllManufacturers();
        List<ManufacturerResponse> data = manufacturers.stream()
                .map(responseMapper::toResponse)
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

        Manufacturer manufacturer = service.getManufacturerById(id);
        ManufacturerResponse data = responseMapper.toResponse(manufacturer);

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
        Manufacturer updated = service.updateManufacturer(id, manufacturer);
        ManufacturerResponse data = responseMapper.toResponse(updated);

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

        Manufacturer manufacturer = service.getManufacturerById(id);
        service.deleteManufacturer(id);
        ManufacturerResponse data = responseMapper.toResponse(manufacturer);

        ApiResponse<ManufacturerResponse> apiResponse = ApiResponse.success(
                data,
                "Manufacturer deleted successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

}
