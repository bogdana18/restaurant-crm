package com.example.demo;

import com.example.demo.models.Inventory;
import com.example.demo.models.Supply;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.SupplyRepository;
import com.example.demo.services.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryServiceTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @Mock
    private SupplyRepository supplyRepository;

    @InjectMocks
    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllInventory() {
        Inventory inventory = new Inventory();
        inventory.setInventoryId("1");
        inventory.setIngredient("Tomato");
        inventory.setQuantity(100);
        inventory.setUnit("kg");

        when(inventoryRepository.findAll()).thenReturn(Collections.singletonList(inventory));

        List<Inventory> inventoryList = inventoryService.getAllInventory();
        assertEquals(1, inventoryList.size());
        assertEquals("Tomato", inventoryList.get(0).getIngredient());
    }

    @Test
    void testGetInventoryById() {
        Inventory inventory = new Inventory();
        inventory.setInventoryId("1");
        inventory.setIngredient("Tomato");

        when(inventoryRepository.findById("1")).thenReturn(Optional.of(inventory));

        Optional<Inventory> foundInventory = inventoryService.getInventoryById("1");
        assertTrue(foundInventory.isPresent());
        assertEquals("Tomato", foundInventory.get().getIngredient());
    }

    @Test
    void testCreateInventory() {
        Inventory inventory = new Inventory();
        inventory.setIngredient("Tomato");

        when(inventoryRepository.save(inventory)).thenReturn(inventory);

        Inventory createdInventory = inventoryService.createInventory(inventory);
        assertEquals("Tomato", createdInventory.getIngredient());
    }

    @Test
    void testUpdateInventory() {
        Inventory inventory = new Inventory();
        inventory.setInventoryId("1");
        inventory.setIngredient("Tomato");

        when(inventoryRepository.save(inventory)).thenReturn(inventory);

        Inventory updatedInventory = inventoryService.updateInventory(inventory);
        assertEquals("Tomato", updatedInventory.getIngredient());
    }

    @Test
    void testDeleteInventory() {
        String inventoryId = "1";
        doNothing().when(inventoryRepository).deleteById(inventoryId);
        inventoryService.deleteInventory(inventoryId);
        verify(inventoryRepository, times(1)).deleteById(inventoryId);
    }

    @Test
    void testGetAllSupplies() {
        Supply supply = new Supply();
        supply.setSupplyId("1");
        supply.setSupplierName("Supplier A");

        when(supplyRepository.findAll()).thenReturn(Collections.singletonList(supply));

        List<Supply> supplyList = inventoryService.getAllSupplies();
        assertEquals(1, supplyList.size());
        assertEquals("Supplier A", supplyList.get(0).getSupplierName());
    }

    @Test
    void testGetSupplyById() {
        Supply supply = new Supply();
        supply.setSupplyId("1");
        supply.setSupplierName("Supplier A");

        when(supplyRepository.findById("1")).thenReturn(Optional.of(supply));

        Optional<Supply> foundSupply = inventoryService.getSupplyById("1");
        assertTrue(foundSupply.isPresent());
        assertEquals("Supplier A", foundSupply.get().getSupplierName());
    }

    @Test
    void testCreateSupply() {
        Supply supply = new Supply();
        supply.setSupplierName("Supplier A");

        when(supplyRepository.save(supply)).thenReturn(supply);

        Supply createdSupply = inventoryService.createSupply(supply);
        assertEquals("Supplier A", createdSupply.getSupplierName());
    }

    @Test
    void testUpdateSupply() {
        Supply supply = new Supply();
        supply.setSupplyId("1");
        supply.setSupplierName("Supplier A");

        when(supplyRepository.save(supply)).thenReturn(supply);

        Supply updatedSupply = inventoryService.updateSupply(supply);
        assertEquals("Supplier A", updatedSupply.getSupplierName());
    }

    @Test
    void testDeleteSupply() {
        String supplyId = "1";
        doNothing().when(supplyRepository).deleteById(supplyId);
        inventoryService.deleteSupply(supplyId);
        verify(supplyRepository, times(1)).deleteById(supplyId);
    }
}

