package com.example.demo.models;
import jakarta.persistence.criteria.Order;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "inventory")
public class Inventory {
    @Id
    private String inventoryId;
    private String ingredient;
    private int quantity;
    private String unit;
}
