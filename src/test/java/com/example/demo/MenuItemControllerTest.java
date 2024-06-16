package com.example.demo;
import com.example.demo.controllers.MenuItemController;
import com.example.demo.models.MenuItem;
import com.example.demo.services.MenuItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
class MenuItemControllerTest {

    @Mock
    private MenuItemService menuItemService;

    @Mock
    private Model model;

    @InjectMocks
    private MenuItemController menuItemController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMenuItems() {
        // Arrange
        List<MenuItem> menuItems = Arrays.asList(
                new MenuItem("1", "Item1", "Description1", 10.0, "Category1"),
                new MenuItem("2", "Item2", "Description2", 15.0, "Category2")
        );
        when(menuItemService.getAllMenuItems()).thenReturn(menuItems);

        // Act
        String viewName = menuItemController.getAllMenuItems(model);

        // Assert
        verify(menuItemService, times(1)).getAllMenuItems();
        verify(model, times(1)).addAttribute("menuItems", menuItems);
        assertEquals("menu", viewName);
    }

    @Test
    void testGetMenuItemById() {
        // Arrange
        MenuItem menuItem = new MenuItem("1", "Item1", "Description1", 10.0, "Category1");
        when(menuItemService.getMenuItemById("1")).thenReturn(Optional.of(menuItem));

        // Act
        String viewName = menuItemController.getMenuItemById("1", model);

        // Assert
        verify(menuItemService, times(1)).getMenuItemById("1");
        verify(model, times(1)).addAttribute("menuItem", menuItem);
        assertEquals("menu-detail", viewName);
    }

    @Test
    void testCreateMenuItem() {
        // Arrange
        MenuItem menuItem = new MenuItem("1", "Item1", "Description1", 10.0, "Category1");

        // Act
        String viewName = menuItemController.createMenuItem(menuItem);

        // Assert
        verify(menuItemService, times(1)).createMenuItem(menuItem);
        assertEquals("redirect:/menu", viewName);
    }

    @Test
    void testUpdateMenuItem() {
        // Arrange
        MenuItem menuItem = new MenuItem("1", "Item1", "Description1", 10.0, "Category1");

        // Act
        String viewName = menuItemController.updateMenuItem(menuItem);

        // Assert
        verify(menuItemService, times(1)).updateMenuItem(menuItem);
        assertEquals("redirect:/menu", viewName);
    }

    @Test
    void testDeleteMenuItem() {
        // Act
        String viewName = menuItemController.deleteMenuItem("1");

        // Assert
        verify(menuItemService, times(1)).deleteMenuItem("1");
        assertEquals("redirect:/menu", viewName);
    }
}
