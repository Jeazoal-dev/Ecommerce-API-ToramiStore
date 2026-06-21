package com.torami.ToramiStore.application.service.products;

import com.torami.ToramiStore.application.port.in.filters.ICategoryService;
import com.torami.ToramiStore.application.port.in.filters.ILineService;
import com.torami.ToramiStore.application.port.in.filters.IManufacturerService;
import com.torami.ToramiStore.application.port.in.filters.ISerieService;
import com.torami.ToramiStore.application.port.in.products.IFigureService;
import com.torami.ToramiStore.application.port.out.products.IFigureRepository;
import com.torami.ToramiStore.domain.models.filters.Category;
import com.torami.ToramiStore.domain.models.filters.Line;
import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import com.torami.ToramiStore.domain.models.filters.Serie;
import com.torami.ToramiStore.domain.models.products.Figure;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FiguraUseCase implements IFigureService {

    private final IFigureRepository figureRepository;
    private final ICategoryService categoryService;
    private final ILineService lineService;
    private final IManufacturerService manufacturerService;
    private final ISerieService serviceService;


    @Override
    public Figure createFigure(Integer code,
                               String name,
                               Double price,
                               Integer quantity,
                               Integer categoryId,
                               Integer lineId,
                               Integer manufacturerId,
                               Integer serieId) {

        Category category = categoryService.getCategoryById(categoryId);
        Line line = lineService.getLineById(lineId);
        Manufacturer manufacturer = manufacturerService.getManufacturerById(manufacturerId);
        Serie serie = serviceService.getSerieById(serieId);
        Figure figure = new Figure(code, name, price, quantity, category, line, manufacturer, serie);
        return figureRepository.save(figure);
    }

    @Override
    public Figure getFigureById(Integer id) {
        return figureRepository.findById(id).orElseThrow(() -> new RuntimeException("Figura no encontrada"));
    }
}
