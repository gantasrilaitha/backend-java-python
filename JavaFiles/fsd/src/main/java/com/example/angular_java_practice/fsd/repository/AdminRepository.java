package com.example.angular_java_practice.fsd.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.angular_java_practice.fsd.entity.Admin;

@Repository
@Transactional
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByUsernameAndPassword(String username, String password);
}
