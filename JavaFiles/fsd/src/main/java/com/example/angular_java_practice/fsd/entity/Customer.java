package com.example.angular_java_practice.fsd.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String location;

    public Customer(){

    }

    public Customer(int age, int id, String location, String name) {
        this.age = age;
        this.id = id;
        this.location = location;
        this.name = name;
    }
    



}
