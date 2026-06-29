package com.torami.ToramiStore.application.port.out.filters;

import com.torami.ToramiStore.domain.models.filters.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {

    Category save(Category category);

    Optional<Category> findById(Integer id);

    List<Category> findAll();

    void delete(Integer id);

    boolean existsById(Integer id);

    boolean existsByName(String name);

    Category findByName(String name);

    int countFiguresByCategoryId(Integer categoryId);

    long count();

}
