package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.filters.ILineService;
import com.torami.ToramiStore.domain.models.filters.Line;
import com.torami.ToramiStore.infrastructure.dto.request.filters.CreateLineRequest;
import com.torami.ToramiStore.infrastructure.dto.request.filters.UpdateLineRequest;
import com.torami.ToramiStore.infrastructure.dto.response.filters.LineResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.LineResponseMapper;
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
    public ResponseEntity<LineResponse> getLineById(@PathVariable Integer id) {
        Line save = lineService.getLineById(id);
        LineResponse response = lineResponseMapper.toResponse(save);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<LineResponse>> getAllLines() {
        List<Line> line = lineService.getAllLines();
        List<LineResponse> response = line.stream()
                .map(lineResponseMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<LineResponse> createLine(@RequestBody CreateLineRequest request) {
        Line line = new Line(request.getName());
        Line save = lineService.createLine(line);
        LineResponse response = lineResponseMapper.toResponse(save);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LineResponse> updateLine(@PathVariable Integer id, @RequestBody UpdateLineRequest request) {
        Line line = new Line(request.getName());
        Line save = lineService.updateLine(id, line);
        LineResponse response = lineResponseMapper.toResponse(save);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LineResponse> deleteLineById(@PathVariable Integer id) {
        Line line = lineService.getLineById(id);
        lineService.deleteLine(id);
        LineResponse response = lineResponseMapper.toResponse(line);
        return ResponseEntity.ok(response);
    }
}
