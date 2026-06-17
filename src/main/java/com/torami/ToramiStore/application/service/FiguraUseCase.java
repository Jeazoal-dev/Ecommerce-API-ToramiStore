package com.torami.ToramiStore.application.service;

import com.torami.ToramiStore.application.port.in.IFigureService;
import com.torami.ToramiStore.application.port.out.ICategoryRepository;
import com.torami.ToramiStore.application.port.out.IFigureRepository;
import com.torami.ToramiStore.domain.model.Category;
import com.torami.ToramiStore.domain.model.Figure;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FiguraUseCase implements IFigureService {

    private final IFigureRepository figureRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public Figure createFigure(Integer code,
                               String name,
                               Double price,
                               Integer quantity,
                               Integer categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Figure figure = new Figure(code, name, price, quantity, category);

        return figureRepository.save(figure);
    }

    @Override
    public Figure getFigureById(Integer id) {
        return figureRepository.findById(id).orElseThrow(()-> new RuntimeException("Figura no encontrada"));
    }
}
