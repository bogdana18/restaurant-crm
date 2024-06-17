package com.example.demo;

import com.example.demo.models.MenuItem;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.services.MenuItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MenuItemServiceTest {

    @Mock
    private MenuItemRepository menuItemRepository;

    @InjectMocks
    private MenuItemService menuItemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMenuItems() {
        // Arrange
        List<MenuItem> menuItems = Arrays.asList(
                new MenuItem("1", "Item1", "Description1", 10, "Category1"),
                new MenuItem("2", "Item2", "Description2", 15, "Category2")
        );
        when(menuItemRepository.findAll()).thenReturn(menuItems);

        // Act
        List<MenuItem> result = menuItemService.getAllMenuItems();

        // Assert
        assertEquals(2, result.size());
        assertEquals(menuItems, result);
        verify(menuItemRepository, times(1)).findAll();
    }

    @Test
    void testGetMenuItemById() {
        // Arrange
        MenuItem menuItem = new MenuItem("1", "Item1", "Description1", 10, "Category1");
        when(menuItemRepository.findById("1")).thenReturn(Optional.of(menuItem));

        // Act
        Optional<MenuItem> result = menuItemService.getMenuItemById("1");

        // Assert
        assertTrue(result.isPresent());
        assertEquals(menuItem, result.get());
        verify(menuItemRepository, times(1)).findById("1");
    }

    @Test
    void testCreateMenuItem() {
        // Arrange
        MenuItem menuItem = new MenuItem("1", "Item1", "Description1", 10, "Category1");
        when(menuItemRepository.save(menuItem)).thenReturn(menuItem);

        // Act
        MenuItem result = menuItemService.createMenuItem(menuItem);

        // Assert
        assertEquals(menuItem, result);
        verify(menuItemRepository, times(1)).save(menuItem);
    }

    @Test
    void testUpdateMenuItem() {
        // Arrange
        MenuItem menuItem = new MenuItem("1", "Item1", "Description1", 10, "Category1");
        when(menuItemRepository.save(menuItem)).thenReturn(menuItem);

        // Act
        MenuItem result = menuItemService.updateMenuItem(menuItem);

        // Assert
        assertEquals(menuItem, result);
        verify(menuItemRepository, times(1)).save(menuItem);
    }

    @Test
    void testDeleteMenuItem() {
        // Arrange
        String menuItemId = "1";

        // Act
        menuItemService.deleteMenuItem(menuItemId);

        // Assert
        verify(menuItemRepository, times(1)).deleteById(menuItemId);
    }
}
