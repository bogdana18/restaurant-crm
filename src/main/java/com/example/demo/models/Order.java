package com.example.demo.models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;
@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String orderId;
    private String customerId;
    private Date orderDate;
    private String status;
    private float totalPrice;
    private List<OrderDetail> orderDetails;
}
