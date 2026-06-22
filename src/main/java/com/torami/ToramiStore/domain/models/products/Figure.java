package com.torami.ToramiStore.domain.models.products;

import com.torami.ToramiStore.domain.exceptions.filters.InvalidFigureException;
import com.torami.ToramiStore.domain.models.filters.Category;
import com.torami.ToramiStore.domain.models.filters.Line;
import com.torami.ToramiStore.domain.models.filters.Manufacturer;
import com.torami.ToramiStore.domain.models.filters.Serie;

public class Figure {

    int id;
    int code;
    String name;
    double price;
    int quantity;
    Category category;
    Line line;
    Manufacturer manufacturer;
    Serie serie;

    public int getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Category getCategory() {
        return category;
    }

    public Line getLine() {
        return line;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Serie getSerie() {
        return serie;
    }


    public Figure(Integer code, String name, Double price, Integer quantity, Category category, Line line, Manufacturer manufacturer, Serie serie) {
        if (price <= 0) throw new InvalidFigureException("The price must be greater than 0");
        if (quantity < 0) throw new InvalidFigureException("The quantity can't be negative");
        if (code == null || code <= 0) throw new InvalidFigureException("invalid code");
        if (name == null || name.trim().isEmpty()) throw new InvalidFigureException("invalid name");

        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.line = line;
        this.manufacturer = manufacturer;
        this.serie = serie;
    }

    public Figure(Integer id, Integer code, String name, Double price, Integer quantity, Category category, Line line, Manufacturer manufacturer, Serie serie) {
        this(code, name, price, quantity, category, line, manufacturer, serie);
        this.id = id;
    }
}
