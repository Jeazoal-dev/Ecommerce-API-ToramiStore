package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.ICategoryService;
import com.torami.ToramiStore.application.port.out.filters.ICategoryRepository;
import com.torami.ToramiStore.domain.exceptions.filters.CategoryNotFoundException;
import com.torami.ToramiStore.domain.models.filters.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryUseCase implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Integer id, Category category) {
        getCategoryById(id);
        Category categoryToUpdate = new Category(id, category.getName());
        return categoryRepository.save(categoryToUpdate);
    }

    @Override
    public void deleteCategory(Integer id) {
        getCategoryById(id);
        categoryRepository.deleteCategory(id);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    public boolean existsCategory(Integer id) {
        return false;
    }
}
