package com.example.angular_java_practice.fsd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data

@Table(name = "users")
@Entity

public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Group> groups;
}
