package com.example.angular_java_practice.fsd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.angular_java_practice.fsd.entity.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    

}
