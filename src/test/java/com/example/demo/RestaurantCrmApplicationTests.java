package com.example.demo;

import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.RestaurantService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantServiceTest {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private RestaurantService restaurantService;

	@Test
	void testCreateCustomer() {
		MockitoAnnotations.openMocks(this);

		Customer customer = new Customer();
		customer.setName("John Doe");

		when(customerRepository.save(any(Customer.class))).thenReturn(customer);

		Customer created = restaurantService.createCustomer(customer);
		assertEquals("John Doe", created.getName());
	}

	// Add more tests as needed
}
