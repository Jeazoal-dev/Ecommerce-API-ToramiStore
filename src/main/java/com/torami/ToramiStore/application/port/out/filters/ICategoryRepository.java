package com.torami.ToramiStore.application.port.out.filters;

import com.torami.ToramiStore.domain.models.filters.Category;

import java.util.Optional;

public interface ICategoryRepository {
    Optional<Category> findById(Integer id);
}
