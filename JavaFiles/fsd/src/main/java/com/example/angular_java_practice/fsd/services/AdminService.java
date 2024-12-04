package com.example.angular_java_practice.fsd.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular_java_practice.fsd.entity.Admin;
import com.example.angular_java_practice.fsd.repository.AdminRepository;

@Service
public class AdminService {
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
    
}
