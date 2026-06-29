package com.torami.ToramiStore.infrastructure.persistence.adapter.filters;

import com.torami.ToramiStore.application.port.out.filters.ICategoryRepository;
import com.torami.ToramiStore.domain.models.filters.Category;
import com.torami.ToramiStore.infrastructure.persistence.entity.filters.CategoryEntity;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.CategoryMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.filters.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        CategoryEntity savedEntity = categoryJpaRepository.save(categoryEntity);
        return categoryMapper.toDomain(savedEntity);
    }


    @Override
    public List<Category> findAll() {
        return categoryJpaRepository.findAll().stream()
                .map(categoryMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryJpaRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryJpaRepository.findById(id)
                .map(categoryMapper::toDomain);
    }

    @Override
    public boolean existsById(Integer id) {
        return categoryJpaRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return categoryJpaRepository.existsByName(name);
    }

    @Override
    public Category findByName(String name) {
        return categoryJpaRepository.findByName(name)
                .map(categoryMapper::toDomain)
                .orElse(null);
    }

    @Override
    public int countFiguresByCategoryId(Integer categoryId) {
        return categoryJpaRepository.countFiguresByCategoryId(categoryId);
    }

    @Override
    public long count() {
        return categoryJpaRepository.count();
    }

}
