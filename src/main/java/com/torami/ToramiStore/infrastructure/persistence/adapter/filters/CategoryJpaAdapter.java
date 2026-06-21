package com.torami.ToramiStore.infrastructure.persistence.adapter.filters;

import com.torami.ToramiStore.application.port.out.filters.ICategoryRepository;
import com.torami.ToramiStore.domain.models.filters.Category;
import com.torami.ToramiStore.infrastructure.persistence.mapper.filters.CategoryMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.filters.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryJpaRepository.findById(id)
                .map(categoryMapper::toDomain);
    }
}
