package com.example.embedded.controller;

import com.example.embedded.model.Order;
import com.example.embedded.repository.OrderRepository;
import com.example.embedded.exception.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@ApiOperation(value = "Order Controller")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/order")
    @ApiOperation(value = "Method to create an Order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Date date = new Date();
        order.setCreatedDate(date);
        return new ResponseEntity<>(orderRepository.save(order), HttpStatus.CREATED);
    }

    @GetMapping("/order/{id}")
    @ApiOperation(value = "Method to get Order by id")
    public ResponseEntity<Order> getOrdersById(@PathVariable Long id){
        Optional<Order> findOrder = orderRepository.findById(id);
        if(findOrder.isPresent()){
            return new ResponseEntity<>(findOrder.get(), HttpStatus.OK);
        }
        else{
            throw new ResourceNotFoundException("id=" + id);
        }
    }

    @GetMapping("/order")
    @ApiOperation(value = "Method to get all Orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

}
