package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.models.Order;
import com.example.demo.services.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    public RestaurantService restaurantService;

    @Operation(summary = "Create customers")
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return restaurantService.createCustomer(customer);
    }

    @Operation(summary = "Get customer by id")
    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomer(@PathVariable String id) {
        return restaurantService.getCustomer(id);
    }

    @Operation(summary = "Get customer by id")
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return restaurantService.getAllCustomers();
    }

    @Operation(summary = "Get all customers")
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return restaurantService.createOrder(order);
    }

    @Operation(summary = "Get order by id")
    @GetMapping("/orders/{id}")
    public Optional<Order> getOrder(@PathVariable String id) {
        return restaurantService.getOrder(id);
    }

    @Operation(summary = "Get all orders")
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return restaurantService.getAllOrders();
    }
}
