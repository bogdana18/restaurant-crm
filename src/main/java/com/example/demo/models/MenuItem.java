package com.example.demo.models;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "menu")
public class MenuItem {
    @Id
    private String menuItemId;
    private String name;
    private String description;
    private float price;
    private String category;

    public MenuItem(String number, String item1, String description1, double v, String category1) {
    }
}
