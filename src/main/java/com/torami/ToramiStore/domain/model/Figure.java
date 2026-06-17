package com.torami.ToramiStore.domain.model;

import com.torami.ToramiStore.domain.exception.InvalidFigureException;

public class Figure {

    int id;
    int code;
    String name;
    double price;
    int quantity;

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

    public Figure(Integer code, String name, Double price, Integer quantity) {
        if (price <= 0) throw new InvalidFigureException("Precio debe ser mayor a 0");
        if (quantity < 0) throw new InvalidFigureException("Cantidad no puede ser negativa");

        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Figure(Integer id, Integer code, String name, Double price, Integer quantity) {
        this(code, name, price, quantity);
        this.id = id;
    }
}
