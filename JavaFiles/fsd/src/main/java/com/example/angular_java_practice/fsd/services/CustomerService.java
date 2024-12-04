package com.example.angular_java_practice.fsd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular_java_practice.fsd.entity.Customer;
import com.example.angular_java_practice.fsd.exception.InvalidAgeException;
import com.example.angular_java_practice.fsd.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository csr;

    public Customer create_customer(Customer customer) {
        if (customer.getAge() > 20) {
            throw new InvalidAgeException("Age cannot exceed 20.");
        }
        return csr.save(customer);
    }

    public Optional<Customer> get_customer_by_id(Integer id) {
        return csr.findById(id);
    }
    public void deleteCustomerById(Integer id) {
        csr.deleteById(id);
    }
    
    

   
   
   
   
   
    public List<Customer> get_all_cus() {
        return csr.findAll();
    }
}
