package com.example.demo.models;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "menu")
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
    @Id
    private String menuItemId;
    private String name;
    private String description;
    private float price;
    private String category;
}
