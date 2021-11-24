package com.shamayko.Homework5Task3.data;

public class Product {
    private Long id;
    private String title;
    private Integer quantity;
    private Float cost;

    public Product() {
    }

    public Product(Long id, String title, Integer quantity, Float cost) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
       if (quantity < 0) {this.quantity = 0;} else {this.quantity = quantity;}
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
