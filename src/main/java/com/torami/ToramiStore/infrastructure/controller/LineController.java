package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.filters.ILineService;
import com.torami.ToramiStore.domain.models.filters.Line;
import com.torami.ToramiStore.infrastructure.dto.request.filters.line.CreateLineRequest;
import com.torami.ToramiStore.infrastructure.dto.request.filters.line.UpdateLineRequest;
import com.torami.ToramiStore.infrastructure.dto.response.ApiResponse;
import com.torami.ToramiStore.infrastructure.dto.response.filters.LineResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.LineResponseMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/line")
@RequiredArgsConstructor
public class LineController {

    private final ILineService lineService;
    private final LineResponseMapper lineResponseMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LineResponse>> getLineById(
            @PathVariable Integer id,
            HttpServletRequest request) {

        Line line = lineService.getLineById(id);
        LineResponse data = lineResponseMapper.toResponse(line);

        ApiResponse<LineResponse> apiResponse = ApiResponse.success(
                data,
                "Line retrieved successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<LineResponse>>> getAllLines(
            HttpServletRequest request) {

        List<Line> lines = lineService.getAllLines();
        List<LineResponse> data = lines.stream()
                .map(lineResponseMapper::toResponse)
                .collect(Collectors.toList());

        ApiResponse<List<LineResponse>> apiResponse = ApiResponse.success(
                data,
                "Lines retrieved successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<LineResponse>> createLine(
            @Valid @RequestBody CreateLineRequest request,
            HttpServletRequest httpRequest) {

        Line line = new Line(request.getName());
        Line saved = lineService.createLine(line);
        LineResponse data = lineResponseMapper.toResponse(saved);

        ApiResponse<LineResponse> apiResponse = ApiResponse.created(
                data,
                "Line created successfully",
                httpRequest.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LineResponse>> updateLine(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateLineRequest request,
            HttpServletRequest httpRequest) {

        Line line = new Line(request.getName());
        Line updated = lineService.updateLine(id, line);
        LineResponse data = lineResponseMapper.toResponse(updated);

        ApiResponse<LineResponse> apiResponse = ApiResponse.success(
                data,
                "Line updated successfully",
                httpRequest.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<LineResponse>> deleteLine(
            @PathVariable Integer id,
            HttpServletRequest request) {

        Line line = lineService.getLineById(id);
        lineService.deleteLine(id);
        LineResponse data = lineResponseMapper.toResponse(line);

        ApiResponse<LineResponse> apiResponse = ApiResponse.success(
                data,
                "Line deleted successfully",
                request.getRequestURI()
        );

        return ResponseEntity.ok(apiResponse);
    }
}
