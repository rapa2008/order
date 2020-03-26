package com.example.embedded.controller;

import com.example.embedded.model.Order;
import com.example.embedded.model.Product;
import com.example.embedded.repository.OrderRepository;
import com.example.embedded.exception.ResourceNotFoundException;
import com.example.embedded.repository.ProductRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    ProductRepository productRepository;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping("/orders")
    @ApiOperation(value = "Method to create an Order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Date date = new Date();
        order.setCreatedDate(date);
        logger.info("Create Order " + order);
        List<Product> listOfProducts = order.getProducts();
        order.setProducts(null);
        Order newOrder = orderRepository.save(order);
        for(Product product : listOfProducts){
            product.setOrder(newOrder);
            productRepository.saveAndFlush(product);
        }

        return new ResponseEntity<>(orderRepository.getOne(newOrder.getId()), HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    @ApiOperation(value = "Method to get Order by id")
    public ResponseEntity<Order> getOrdersById(@PathVariable Long id){
        logger.info("Query by id " + id);
        Optional<Order> findOrder = orderRepository.findById(id);
        if(findOrder.isPresent()){
            return new ResponseEntity<>(findOrder.get(), HttpStatus.OK);
        }
        else{
            throw new ResourceNotFoundException("Order id " + id + " is not found");
        }
    }

    @GetMapping("/orders")
    @ApiOperation(value = "Method to get all Orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        logger.info("Query All Orders");
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

}
