package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.ICategoryService;
import com.torami.ToramiStore.application.port.out.filters.ICategoryRepository;
import com.torami.ToramiStore.domain.exceptions.filters.category.*;
import com.torami.ToramiStore.domain.models.filters.Category;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class CategoryUseCase implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category createCategory(Category category) {
        try {

            if (categoryRepository.existsByName(category.getName())) {
                throw new CategoryAlreadyExistsException(category.getName());
            }
            return categoryRepository.save(category);

        } catch (CategoryAlreadyExistsException | CategoryInvalidNameException e) {
            throw e;
        } catch (Exception e) {
            throw new CategorySaveException(category.getName(), e.getMessage(), e);
        }
    }


    @Override
    public List<Category> getAllCategories() {
        try {
            return categoryRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving categories: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Category updateCategory(Integer id, Category category) {
        try {
            getCategoryById(id);
            Category existingByName = categoryRepository.findByName(category.getName());

            if (existingByName != null && !existingByName.getId().equals(id)) {
                throw new CategoryAlreadyExistsException(category.getName());
            }
            Category categoryToUpdate = new Category(id, category.getName());
            return categoryRepository.save(categoryToUpdate);
        } catch (CategoryNotFoundException | CategoryAlreadyExistsException | CategoryInvalidNameException e) {
            throw e;
        } catch (Exception e) {
            throw new CategorySaveException(id, e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public void deleteCategory(Integer id) {
        try {
            Category category = getCategoryById(id);

            int figureCount = categoryRepository.countFiguresByCategoryId(id);
            if (figureCount > 0) {
                throw new CategoryHasFiguresException(id, figureCount);
            }

            if (categoryRepository.count() <= 1) {
                throw new CategoryCannotBeDeletedException(id, "Cannot delete the only category");
            }

            categoryRepository.deleteCategory(id);
        } catch (CategoryNotFoundException | CategoryHasFiguresException | CategoryCannotBeDeletedException e) {
            throw e;
        } catch (Exception e) {
            throw new CategoryDeleteException(id, e.getMessage(), e);
        }
    }

    @Override
    public Category getCategoryById(Integer id) {
        try {
            return categoryRepository.findById(id)
                    .orElseThrow(() -> new CategoryNotFoundException(id));
        } catch (CategoryNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving category with ID " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public boolean existsCategory(Integer id) {
        return categoryRepository.existsById(id);
    }
}
