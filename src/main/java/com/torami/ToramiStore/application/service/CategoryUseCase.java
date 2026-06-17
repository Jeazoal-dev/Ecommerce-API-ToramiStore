package com.torami.ToramiStore.application.service;

import com.torami.ToramiStore.application.port.in.ICategoryService;
import com.torami.ToramiStore.application.port.out.ICategoryRepository;
import com.torami.ToramiStore.domain.model.Figure;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryUseCase implements ICategoryService {

    private final ICategoryRepository categoryRepository;

}
