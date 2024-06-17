package com.example.demo.controllers;

import com.example.demo.models.MenuItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MenuItemControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private MenuItem menuItem;

    @BeforeEach
    public void setUp() {
        menuItem = new MenuItem(UUID.randomUUID().toString(), "Item1", "Description1", 10.0f, "Category1");
    }

    @Test
    public void testCreateMenuItem() throws Exception {
        mockMvc.perform(post("/menu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menuItem)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(menuItem.getName()));
    }

    @Test
    public void testGetMenuItemById() throws Exception {
        mockMvc.perform(post("/menu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menuItem)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/menu/{id}", menuItem.getMenuItemId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(menuItem.getName()));
    }

    @Test
    public void testGetAllMenuItems() throws Exception {
        mockMvc.perform(post("/menu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menuItem)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/menu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
