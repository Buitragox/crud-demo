package com.example.cruddemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "item")
public class Item {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name")
    @NotBlank(message = "Item name cannot be blank")
    private String name;

    @Column(name = "quantity")
    @PositiveOrZero(message = "Quantity must be non negative")
    private int quantity;

    @Column(name = "price")
    @PositiveOrZero(message = "Price must be non negative")
    private double price;

    public Item() {
    }

    public Item(Long id, String name, int quantity) {
        Id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
