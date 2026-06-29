package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.filters.ICategoryService;
import com.torami.ToramiStore.domain.models.filters.Category;
import com.torami.ToramiStore.infrastructure.dto.request.filters.category.CreateCategoryRequest;
import com.torami.ToramiStore.infrastructure.dto.request.filters.category.UpdateCategoryRequest;
import com.torami.ToramiStore.infrastructure.dto.response.ApiResponse;
import com.torami.ToramiStore.infrastructure.dto.response.filters.CategoryResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.CategoryResponseMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService service;
    private final CategoryResponseMapper responseMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponse>>> getAllCategories(HttpServletRequest request) {
        List<Category> categories = service.getAllCategories();
        List<CategoryResponse> data = categories.stream()
                .map(responseMapper::toResponse)
                .collect(Collectors.toList());

        ApiResponse<List<CategoryResponse>> apiResponse = ApiResponse.success(
                data,
                "Categories retrieved successfully",
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategoryById(
            @PathVariable Integer id,
            HttpServletRequest request) {

        Category saved = service.getCategoryById(id);
        CategoryResponse data = responseMapper.toResponse(saved);

        ApiResponse<CategoryResponse> apiResponse = ApiResponse.success(
                data,
                "Category retrieved successfully",
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(
            @Valid @RequestBody CreateCategoryRequest request,
            HttpServletRequest httpRequest) {

        Category category = new Category(request.getName());
        Category saved = service.createCategory(category);
        CategoryResponse data = responseMapper.toResponse(saved);

        ApiResponse<CategoryResponse> apiResponse = ApiResponse.created(
                data,
                "Category created successfully",
                httpRequest.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> updateCategory(
            @PathVariable Integer id, @Valid @RequestBody UpdateCategoryRequest request,
            HttpServletRequest httpRequest) {

        Category category = new Category(request.getName());
        Category saved = service.updateCategory(id, category);
        CategoryResponse data = responseMapper.toResponse(saved);

        ApiResponse<CategoryResponse> apiResponse = ApiResponse.success(
                data,
                "Category update successfully",
                httpRequest.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryResponse>> deleteCategory(
            @PathVariable Integer id,
            HttpServletRequest httpRequest) {

        Category category = service.getCategoryById(id);
        CategoryResponse data = responseMapper.toResponse(category);
        service.deleteCategory(id);

        ApiResponse<CategoryResponse> apiResponse = ApiResponse.success(
                data,
                "Category deleted successfully",
                httpRequest.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

}
