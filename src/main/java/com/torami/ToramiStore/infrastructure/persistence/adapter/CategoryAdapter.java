package com.torami.ToramiStore.infrastructure.persistence.adapter;

import com.torami.ToramiStore.application.port.in.ICategoryService;
import com.torami.ToramiStore.application.port.out.ICategoryRepository;
import com.torami.ToramiStore.domain.model.Category;
import com.torami.ToramiStore.infrastructure.persistence.mapper.CategoryMapper;
import com.torami.ToramiStore.infrastructure.persistence.repository.CategoryJpaRepository;
import com.torami.ToramiStore.infrastructure.persistence.repository.FigureJpaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryRepository {

    private  final CategoryJpaRepository categoryJpaRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryJpaRepository.findById(id)
                .map(categoryMapper::toDomain);
    }
}
