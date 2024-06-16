package com.example.demo.models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "reviews")
public class Review {
    @Id
    private String reviewId;
    private String customerId;
    private int rating;
    private String comment;
    private Date date;
}
