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

    private final CategoryJpaRepository jpaRepository;
    private final CategoryMapper mapper;

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = mapper.toEntity(category);
        CategoryEntity savedEntity = jpaRepository.save(categoryEntity);
        return mapper.toDomain(savedEntity);
    }


    @Override
    public List<Category> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsById(Integer id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return jpaRepository.existsByName(name);
    }

    @Override
    public Category findByName(String name) {
        return jpaRepository.findByName(name)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public int countFiguresByCategoryId(Integer categoryId) {
        return jpaRepository.countFiguresByCategoryId(categoryId);
    }

    @Override
    public long count() {
        return jpaRepository.count();
    }

}
