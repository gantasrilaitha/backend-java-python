package com.example.angular_java_practice.fsd;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.angular_java_practice.fsd.entity.Customer;
import com.example.angular_java_practice.fsd.exception.InvalidAgeException;
import com.example.angular_java_practice.fsd.repository.CustomerRepository;
import com.example.angular_java_practice.fsd.services.CustomerService;


@ExtendWith(MockitoExtension.class)
public class CustomerEntityServiceTest {

    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerService service;

    @Test
    void testCreate() {
        // Arrange
        Customer customer = new Customer();
        customer.setName("Test Entity");

        Customer savedcustomer = new Customer();
        savedcustomer.setId(3);
        savedcustomer.setName("Test Entity");

        Mockito.when(repository.save(customer)).thenReturn(savedcustomer);

        // Act
        Customer result = service.create_customer(customer);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(savedcustomer.getId(), result.getId());
        Assertions.assertEquals(savedcustomer.getName(), result.getName());

        Mockito.verify(repository, Mockito.times(1)).save(customer);
    }

     @Test
    void testCreateCustomer_InvalidAgeException() {
        // Arrange
        Customer customer = new Customer();
        customer.setName("Invalid Customer");
        customer.setAge(25); // Invalid age
        customer.setLocation("Invalid Location");

        // Act & Assert
        InvalidAgeException exception = Assertions.assertThrows(
                InvalidAgeException.class,
                () -> service.create_customer(customer)
        );

        Assertions.assertEquals("Age cannot exceed 20.", exception.getMessage());
        Mockito.verify(repository, Mockito.never()).save(Mockito.any());
    }


}
