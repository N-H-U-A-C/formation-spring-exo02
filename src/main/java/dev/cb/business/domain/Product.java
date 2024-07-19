package dev.cb.business.domain;

import dev.cb.utils.enums.Category;

import java.util.UUID;

public class Product {

    private UUID id;
    private String name;
    private Category category;
    private double price;

    public Product() {
    }

    public Product(UUID id, String name, Category category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
