package com.example.embedded.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long productId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @NotNull
    @JsonIgnore
    private Order order;

    @NotNull
    private Long productNumber;
    @NotNull
    private String name;
    @NotNull
    private String specification;
    private String img;
    @NotNull
    private String price;

    public Product() {
    }

/*    public Product(@NotNull Order order, @NotNull Long productNumber, @NotNull String name, @NotNull String specification, String img, @NotNull String price) {
        this.order = order;
        this.productNumber = productNumber;
        this.name = name;
        this.specification = specification;
        this.img = img;
        this.price = price;
    }*/

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
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
