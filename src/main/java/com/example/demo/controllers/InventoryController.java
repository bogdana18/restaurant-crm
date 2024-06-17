package com.example.demo.controllers;

import com.example.demo.models.Inventory;
import com.example.demo.models.Supply;
import com.example.demo.services.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/inventory")
@Tag(name = "Inventory Management")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Operation(summary = "Get all inventory items")
    @GetMapping
    public String getAllInventory(Model model) {
        List<Inventory> inventoryList = inventoryService.getAllInventory();
        model.addAttribute("inventoryList", inventoryList);
        return "inventory";
    }

    @Operation(summary = "Get inventory item by ID")
    @GetMapping("/{id}")
    public String getInventoryById(@PathVariable String id, Model model) {
        Optional<Inventory> inventory = inventoryService.getInventoryById(id);
        inventory.ifPresent(value -> model.addAttribute("inventory", value));
        return "inventory-detail";
    }

    @Operation(summary = "Create new inventory item")
    @PostMapping
    public String createInventory(@ModelAttribute Inventory inventory) {
        inventoryService.createInventory(inventory);
        return "redirect:/inventory";
    }

    @Operation(summary = "Update inventory item")
    @PostMapping("/update")
    public String updateInventory(@ModelAttribute Inventory inventory) {
        inventoryService.updateInventory(inventory);
        return "redirect:/inventory";
    }

    @Operation(summary = "Delete inventory item by ID")
    @GetMapping("/delete/{id}")
    public String deleteInventory(@PathVariable String id) {
        inventoryService.deleteInventory(id);
        return "redirect:/inventory";
    }

    @Operation(summary = "Get all supply items")
    @GetMapping("/supplies")
    public String getAllSupplies(Model model) {
        List<Supply> supplyList = inventoryService.getAllSupplies();
        model.addAttribute("supplyList", supplyList);
        return "supplies";
    }

    @Operation(summary = "Create new supply item")
    @PostMapping("/supplies")
    public String createSupply(@ModelAttribute Supply supply) {
        inventoryService.createSupply(supply);
        return "redirect:/inventory/supplies";
    }

    @Operation(summary = "Update supply item")
    @PostMapping("/supplies/update")
    public String updateSupply(@ModelAttribute Supply supply) {
        inventoryService.updateSupply(supply);
        return "redirect:/inventory/supplies";
    }

    @Operation(summary = "Delete supply item by ID")
    @GetMapping("/supplies/delete/{id}")
    public String deleteSupply(@PathVariable String id) {
        inventoryService.deleteSupply(id);
        return "redirect:/inventory/supplies";
    }
}
