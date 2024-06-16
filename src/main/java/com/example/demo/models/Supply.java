package com.example.demo.models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@Document(collection = "supply")
public class Supply {
    @Id
    private String supplyId;
    private String inventoryId;
    private int quantity;
    private Date dateSupplied;
    private String supplierName;
}
