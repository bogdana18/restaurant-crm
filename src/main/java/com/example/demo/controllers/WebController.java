package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.models.Order;
import com.example.demo.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class WebController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("customers", restaurantService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", restaurantService.getAllOrders());
        return "orders";
    }

    @PostMapping("/customers")
    public String createCustomer(Customer customer) {
        restaurantService.createCustomer(customer);
        return "redirect:/customers";
    }

    @PostMapping("/orders")
    public String createOrder(Order order) {
        restaurantService.createOrder(order);
        return "redirect:/orders";
    }
}