package com.torami.ToramiStore.application.port.in.filters;

import com.torami.ToramiStore.domain.models.filters.Category;

public interface ICategoryService {
    Category getCategoryById(Integer id);
}
