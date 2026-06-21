package com.torami.ToramiStore.application.service.filters;

import com.torami.ToramiStore.application.port.in.filters.ICategoryService;
import com.torami.ToramiStore.application.port.out.filters.ICategoryRepository;
import com.torami.ToramiStore.domain.exceptions.filters.CategoryNotFoundException;
import com.torami.ToramiStore.domain.models.filters.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryUseCase implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
