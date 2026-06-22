package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(Category category);

    List<Category> getAllCategories();

    Category updateCategory(Integer id, Category category);

    void deleteCategory(Integer id);

    Category getCategoryById(Integer id);

    boolean existsCategory(Integer id);
}
