package com.torami.ToramiStore.domain.model;
import com.torami.ToramiStore.domain.model.Category;
import com.torami.ToramiStore.domain.exception.InvalidFigureException;

public class Figure {

    int id;
    int code;
    String name;
    double price;
    int quantity;
    Category category;

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

    public Category getCategory(){
        return category;
    }


    public Figure(Integer code, String name, Double price, Integer quantity, Category category) {
        if (price <= 0) throw new InvalidFigureException("The price must be greater than 0");
        if (quantity < 0) throw new InvalidFigureException("The quantity can't be negative");
        if (code == null || code <= 0) throw new InvalidFigureException("invalid code");
        if (name == null || name.trim().isEmpty()) throw new InvalidFigureException("invalid name");

        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Figure(Integer id, Integer code, String name, Double price, Integer quantity, Category category) {
        this(code, name, price, quantity, category);
        this.id = id;
    }
}
