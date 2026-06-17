package com.torami.ToramiStore.application.port.service;

import com.torami.ToramiStore.application.port.in.IFigureService;
import com.torami.ToramiStore.application.port.out.IFigureRepository;
import com.torami.ToramiStore.domain.model.Figure;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FiguraUseCase implements IFigureService {

    private final IFigureRepository figureRepository;


    @Override
    public Figure createFigure(Integer code, String name, Double price, Integer quantity) {
        Figure figure = new Figure(code,name,price,quantity);
        return figureRepository.save(figure);
    }

    @Override
    public Figure getFigureById(Integer id) {
        return figureRepository.findById(id).orElseThrow(()-> new RuntimeException("Figura no encontrada"));
    }
}
