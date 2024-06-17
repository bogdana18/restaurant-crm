package com.example.demo.controllers;
import com.example.demo.models.MenuItem;
import com.example.demo.services.MenuItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/menu")
@Tag(name = "Menu Management")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @Operation(summary = "Get all menu items")
    @GetMapping
    public String getAllMenuItems(Model model) {
        List<MenuItem> menuItems = menuItemService.getAllMenuItems();
        model.addAttribute("menuItems", menuItems);
        return "menu";
    }

    @Operation(summary = "Get menu item by ID")
    @GetMapping("/{id}")
    public String getMenuItemById(@PathVariable String id, Model model) {
        Optional<MenuItem> menuItem = menuItemService.getMenuItemById(id);
        menuItem.ifPresent(value -> model.addAttribute("menuItem", value));
        return "menu-detail";
    }

    @Operation(summary = "Create new menu item")
    @PostMapping
    public String createMenuItem(@ModelAttribute MenuItem menuItem) {
        menuItemService.createMenuItem(menuItem);
        return "redirect:/menu";
    }

    @Operation(summary = "Update menu item")
    @PostMapping("/update")
    public String updateMenuItem(@ModelAttribute MenuItem menuItem) {
        menuItemService.updateMenuItem(menuItem);
        return "redirect:/menu";
    }

    @Operation(summary = "Delete menu item by ID")
    @GetMapping("/delete/{id}")
    public String deleteMenuItem(@PathVariable String id) {
        menuItemService.deleteMenuItem(id);
        return "redirect:/menu";
    }
}
