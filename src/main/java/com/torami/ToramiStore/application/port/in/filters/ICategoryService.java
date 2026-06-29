package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Category;
import jakarta.validation.constraints.Min;

import java.util.List;

public interface ICategoryService {

    Category getCategoryById(@Min(1) Integer id);

    List<Category> getAllCategories();

    Category createCategory(Category category);

    Category updateCategory(@Min(1) Integer id, Category category);

    void deleteCategory(@Min(1) Integer id);

}
