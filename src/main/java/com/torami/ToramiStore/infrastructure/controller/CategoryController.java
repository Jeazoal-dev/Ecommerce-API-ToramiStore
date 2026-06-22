package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.filters.ICategoryService;
import com.torami.ToramiStore.domain.models.filters.Category;
import com.torami.ToramiStore.infrastructure.dto.request.filters.CreateCategoryRequest;
import com.torami.ToramiStore.infrastructure.dto.request.filters.UpdateCategoryRequest;
import com.torami.ToramiStore.infrastructure.dto.response.filters.CategoryResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.CategoryResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;
    private final CategoryResponseMapper categoryResponseMapper;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryResponse> response = categories.stream()
                .map(categoryResponseMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Integer id) {
        Category saved = categoryService.getCategoryById(id);
        CategoryResponse response = categoryResponseMapper.toResponse(saved);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CreateCategoryRequest request) {
        Category category = new Category(request.getName());
        Category saved = categoryService.createCategory(category);
        CategoryResponse response = categoryResponseMapper.toResponse(saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Integer id, @RequestBody UpdateCategoryRequest request) {
        Category category = new Category(request.getName());
        Category saved = categoryService.updateCategory(id, category);
        CategoryResponse response = categoryResponseMapper.toResponse(saved);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable Integer id) {
        Category category = categoryService.getCategoryById(id);
        categoryService.deleteCategory(id);
        CategoryResponse response = categoryResponseMapper.toResponse(category);
        return ResponseEntity.ok(response);
    }

}
