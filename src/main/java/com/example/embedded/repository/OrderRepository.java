package com.example.embedded.repository;

import com.example.embedded.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
