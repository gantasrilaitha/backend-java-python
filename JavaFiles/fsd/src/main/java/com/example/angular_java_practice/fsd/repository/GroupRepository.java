package com.example.angular_java_practice.fsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.angular_java_practice.fsd.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}