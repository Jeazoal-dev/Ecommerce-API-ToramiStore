package com.torami.ToramiStore.application.port.out;

import com.torami.ToramiStore.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {
    Optional<Category> findById(Integer id);
}
