package com.example.embedded.model;

import javax.validation.constraints.NotNull;

public class Product {
    @NotNull
    private String name;
    private String specification;
    private String img;
    @NotNull
    private String price;

    public Product(String name, String specification, String price) {
        this.name = name;
        this.specification = specification;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                ", img='" + img + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
