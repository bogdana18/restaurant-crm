package com.example.demo.controllers;
import com.example.demo.models.MenuItem;
import com.example.demo.services.MenuItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/menu")
@Api(tags = "Menu Management")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @ApiOperation(value = "Get all menu items")
    @GetMapping
    public String getAllMenuItems(Model model) {
        List<MenuItem> menuItems = menuItemService.getAllMenuItems();
        model.addAttribute("menuItems", menuItems);
        return "menu";
    }

    @ApiOperation(value = "Get menu item by ID")
    @GetMapping("/{id}")
    public String getMenuItemById(@PathVariable String id, Model model) {
        Optional<MenuItem> menuItem = menuItemService.getMenuItemById(id);
        menuItem.ifPresent(value -> model.addAttribute("menuItem", value));
        return "menu-detail";
    }

    @ApiOperation(value = "Create new menu item")
    @PostMapping
    public String createMenuItem(@ModelAttribute MenuItem menuItem) {
        menuItemService.createMenuItem(menuItem);
        return "redirect:/menu";
    }

    @ApiOperation(value = "Update menu item")
    @PostMapping("/update")
    public String updateMenuItem(@ModelAttribute MenuItem menuItem) {
        menuItemService.updateMenuItem(menuItem);
        return "redirect:/menu";
    }

    @ApiOperation(value = "Delete menu item by ID")
    @GetMapping("/delete/{id}")
    public String deleteMenuItem(@PathVariable String id) {
        menuItemService.deleteMenuItem(id);
        return "redirect:/menu";
    }
}
