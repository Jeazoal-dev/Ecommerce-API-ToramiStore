package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.filters.IManufacturerService;
import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import com.torami.ToramiStore.infrastructure.dto.request.filters.CreateManufacturerRequest;
import com.torami.ToramiStore.infrastructure.dto.request.filters.UpdateManufacturerRequest;
import com.torami.ToramiStore.infrastructure.dto.response.filters.ManufacturerResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.ManufacturerResponseMapper;
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

    @GetMapping
    public ResponseEntity<List<ManufacturerResponse>> getManufacturers() {
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        List<ManufacturerResponse> response = manufacturers.stream()
                .map(manufacturerResponseMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerResponse> getManufacturer(@PathVariable Integer id) {
        Manufacturer manufacturer = manufacturerService.getManufacturerById(id);
        ManufacturerResponse response = manufacturerResponseMapper.toResponse(manufacturer);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ManufacturerResponse> createManufacturer(@RequestBody CreateManufacturerRequest request) {
        Manufacturer manufacturer = new Manufacturer(request.getName());
        ManufacturerResponse response = manufacturerResponseMapper.toResponse(manufacturerService.createManufacturer(manufacturer));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerResponse> updateManufacturer(@PathVariable Integer id, @RequestBody UpdateManufacturerRequest request) {
        Manufacturer manufacturer = new Manufacturer(request.getName());
        Manufacturer saved = manufacturerService.updateManufacturer(id, manufacturer);
        ManufacturerResponse response = manufacturerResponseMapper.toResponse(saved);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ManufacturerResponse> deleteManufacturer(@PathVariable Integer id) {
        Manufacturer manufacturer = manufacturerService.getManufacturerById(id);
        manufacturerService.deleteManufacturer(id);
        ManufacturerResponse response = manufacturerResponseMapper.toResponse(manufacturer);
        return ResponseEntity.ok(response);
    }
}
