package com.example.demo.controllers;

import com.example.demo.models.Inventory;
import com.example.demo.models.Supply;
import com.example.demo.services.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/inventory")
@Api(tags = "Inventory Management")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @ApiOperation(value = "Get all inventory items")
    @GetMapping
    public String getAllInventory(Model model) {
        List<Inventory> inventoryList = inventoryService.getAllInventory();
        model.addAttribute("inventoryList", inventoryList);
        return "inventory";
    }

    @ApiOperation(value = "Get inventory item by ID")
    @GetMapping("/{id}")
    public String getInventoryById(@PathVariable String id, Model model) {
        Optional<Inventory> inventory = inventoryService.getInventoryById(id);
        inventory.ifPresent(value -> model.addAttribute("inventory", value));
        return "inventory-detail";
    }

    @ApiOperation(value = "Create new inventory item")
    @PostMapping
    public String createInventory(@ModelAttribute Inventory inventory) {
        inventoryService.createInventory(inventory);
        return "redirect:/inventory";
    }

    @ApiOperation(value = "Update inventory item")
    @PostMapping("/update")
    public String updateInventory(@ModelAttribute Inventory inventory) {
        inventoryService.updateInventory(inventory);
        return "redirect:/inventory";
    }

    @ApiOperation(value = "Delete inventory item by ID")
    @GetMapping("/delete/{id}")
    public String deleteInventory(@PathVariable String id) {
        inventoryService.deleteInventory(id);
        return "redirect:/inventory";
    }

    @ApiOperation(value = "Get all supply items")
    @GetMapping("/supplies")
    public String getAllSupplies(Model model) {
        List<Supply> supplyList = inventoryService.getAllSupplies();
        model.addAttribute("supplyList", supplyList);
        return "supplies";
    }

    @ApiOperation(value = "Create new supply item")
    @PostMapping("/supplies")
    public String createSupply(@ModelAttribute Supply supply) {
        inventoryService.createSupply(supply);
        return "redirect:/inventory/supplies";
    }

    @ApiOperation(value = "Update supply item")
    @PostMapping("/supplies/update")
    public String updateSupply(@ModelAttribute Supply supply) {
        inventoryService.updateSupply(supply);
        return "redirect:/inventory/supplies";
    }

    @ApiOperation(value = "Delete supply item by ID")
    @GetMapping("/supplies/delete/{id}")
    public String deleteSupply(@PathVariable String id) {
        inventoryService.deleteSupply(id);
        return "redirect:/inventory/supplies";
    }
}
