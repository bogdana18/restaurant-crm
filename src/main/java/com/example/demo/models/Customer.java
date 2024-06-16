package com.example.demo.models;
import jakarta.persistence.criteria.Order;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document(collection = "customers")
public class Customer {
    @Id
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Order> orders;
}
