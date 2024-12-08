package com.example.angular_java_practice.fsd.entity;


import lombok.Data;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.Instant;
import java.util.Set;

@Data

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private Instant date;
    private String title;
    private String description;

    @ManyToOne
    private Group group;

    

    @ManyToOne
    //@JoinColumn(name = "user_id", nullable = false) // Foreign key column in the Group table
    private User user;
}