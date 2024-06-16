package com.example.demo.services;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RestaurantService {

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public OrderDetailRepository orderDetailRepository;

    @Autowired
    public MenuItemRepository menuRepository;

    @Autowired
    public ReviewRepository reviewRepository;

    @Autowired
    public InventoryRepository inventoryRepository;

    @Autowired
    public SupplyRepository supplyRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomer(String customerId) {
        return customerRepository.findById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> getOrder(String orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}