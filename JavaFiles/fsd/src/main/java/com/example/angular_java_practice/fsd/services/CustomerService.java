package com.example.angular_java_practice.fsd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.angular_java_practice.fsd.entity.Customer;
import com.example.angular_java_practice.fsd.exception.CustomerNotFoundException;
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
    public Optional<Customer> deleteCustomerById(Integer id) {
        Optional<Customer> customer = get_customer_by_id(id);
        Optional <Customer> cus=customer;
        if (customer.isPresent()) {
            csr.deleteById(id);
            return cus;
        }
        return customer;
    }
    
    public Optional<Customer> update_customer(Integer id,String location){
        Optional<Customer> existingCustomer = get_customer_by_id(id);
        if (existingCustomer.isPresent()) {
            Customer customerToUpdate = existingCustomer.get();
            customerToUpdate.setLocation(location); // update location
            create_customer(customerToUpdate);
        } 
        else {
            
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        return existingCustomer;
    }

   
   
   
   
   
    public List<Customer> get_all_cus() {
        return csr.findAll();
    }

    public List<Customer> get_all_cus_sorted_by_name(){
        List<Customer> c=csr.findAll(Sort.by(Sort.Direction.ASC, "name")); // Use Spring Data JPA's Sort utility
        return c;
    }
}
