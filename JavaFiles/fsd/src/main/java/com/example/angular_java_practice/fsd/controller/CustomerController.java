package com.example.angular_java_practice.fsd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.angular_java_practice.fsd.entity.Admin;
import com.example.angular_java_practice.fsd.entity.Customer;
import com.example.angular_java_practice.fsd.exception.CustomerNotFoundException;
import com.example.angular_java_practice.fsd.exception.InvalidAgeException;
import com.example.angular_java_practice.fsd.services.AdminService;
import com.example.angular_java_practice.fsd.services.CustomerService;

  
@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService cs;

    @Autowired
    private AdminService as;

    @PostMapping("/add_cus")
    public ResponseEntity<?> create_new_customer(@RequestBody Customer cus) {
        try{
            Customer c= cs.create_customer(cus);
            return ResponseEntity.ok(c);
        }catch (InvalidAgeException ex){
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error",  ex.getMessage());
            return ResponseEntity.status(500).body( errorResponse);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> get_cus(@PathVariable Integer id) {
        Optional<Customer> customer = cs.get_customer_by_id(id);
        
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/allcus")
    public List<Customer> get_allcus(){
        return cs.get_all_cus();
    }

    @PutMapping("/update/{id}/{location}")
    public ResponseEntity<?> updateCustomerLocation(@PathVariable Integer id, @PathVariable String location) {
        try{
            Optional<Customer> existingCustomer = cs.update_customer(id,location);
            return ResponseEntity.ok(existingCustomer);

        }catch (CustomerNotFoundException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error",  e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse); 
        }
            
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete_CustomerBy_Id(@PathVariable Integer id) {
        Optional<Customer> customer = cs.deleteCustomerById(id);
        if (customer.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("suc_msg",  "deleted suceessfully");
            return ResponseEntity.ok(response);
            
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "not in db" );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping("/create_admin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = as.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
    }
    @DeleteMapping("/admin/delete/{adminId}/{customerId}")
    public ResponseEntity<String> adminDeleteCustomer(
        @PathVariable Integer adminId,
        @PathVariable Integer customerId
        ) {
        Optional<Admin> admin = as.getAdminById(adminId);
        if (admin.isPresent()) {
            Optional<Customer> customer = as.admin_delete_customer(adminId, customerId);
            if (customer.isPresent()) {
          
                return ResponseEntity.ok("Customer deleted successfully by admin.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: Admin not found.");
        }
    }

    @GetMapping("/sorted_by_name")
    public List<Customer> get_cus_sorted_by_name(){
        return cs.get_all_cus_sorted_by_name();
    }

}