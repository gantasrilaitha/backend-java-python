package com.example.angular_java_practice.fsd.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.angular_java_practice.fsd.entity.Admin;
import com.example.angular_java_practice.fsd.entity.Customer;
import com.example.angular_java_practice.fsd.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private CustomerService cs;

    @Autowired
    private AdminRepository adminRepository;

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
    public Optional<Admin> getAdminById(Integer adminId) {
        return adminRepository.findById(adminId);
    }

    public Optional<Admin> authenticateAdmin(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }
    
    public Optional<Customer> admin_delete_customer(Integer adminId, Integer customerId){
            Optional<Admin> admin = getAdminById(adminId);
            Optional<Customer> c=null;
            if (admin.isPresent()) {
                Optional<Customer> customer = cs.get_customer_by_id(customerId);
                c=customer;
                if (customer.isPresent()) {
                    cs.deleteCustomerById(customerId);
                    
                } 
            }
            return c;
    }
}
