package com.example.embedded.model;

import com.example.embedded.util.HashMapConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

@Entity(name="bt_order")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Convert(converter = HashMapConverter.class)
    @NotNull
    private Map<String, Product> products;

    private Date createdDate;

    public Long getId() {
        return id;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                ", createdDate=" + createdDate +
                '}';
    }
}
