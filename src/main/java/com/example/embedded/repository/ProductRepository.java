package com.example.embedded.repository;

import com.example.embedded.model.Order;
import com.example.embedded.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}