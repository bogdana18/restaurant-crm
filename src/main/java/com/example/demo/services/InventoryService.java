package com.example.demo.services;

import com.example.demo.models.Inventory;
import com.example.demo.models.Supply;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.SupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private SupplyRepository supplyRepository;

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(String inventoryId) {
        return inventoryRepository.findById(inventoryId);
    }

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(String inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    public Optional<Supply> getSupplyById(String supplyId) {
        return supplyRepository.findById(supplyId);
    }

    public Supply createSupply(Supply supply) {
        return supplyRepository.save(supply);
    }

    public Supply updateSupply(Supply supply) {
        return supplyRepository.save(supply);
    }

    public void deleteSupply(String supplyId) {
        supplyRepository.deleteById(supplyId);
    }
}
