package com.example.demo.repository;
import com.example.demo.models.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
}
