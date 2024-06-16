package com.example.demo.models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orderDetails")
public class OrderDetail {
    @Id
    private String orderDetailId;
    private String orderId;
    private String menuItemId;
    private int quantity;
    private float price;
}
