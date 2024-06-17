package com.example.demo.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;
@Data
@Document(collection = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private String orderId;
    private String customerId;
    private Date orderDate;
    private String status;
    private String description;
    private float totalPrice;
    private List<OrderDetail> orderDetails;
}
