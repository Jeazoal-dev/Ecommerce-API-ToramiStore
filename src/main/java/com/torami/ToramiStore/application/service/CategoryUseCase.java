package com.torami.ToramiStore.application.service;

import com.torami.ToramiStore.application.port.in.ICategoryService;
import com.torami.ToramiStore.application.port.out.ICategoryRepository;
import com.torami.ToramiStore.domain.exception.CategoryNotFoundException;
import com.torami.ToramiStore.domain.model.Category;
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
