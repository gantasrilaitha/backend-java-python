package com.example.angular_java_practice.fsd.entity;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
// @NoArgsConstructor//Generates a no-argument (default) constructor for the
// class.
//@RequiredArgsConstructor // Generates a constructor for all final fields and fields annotated with
                         // @NonNull.

@Table(name = "user_group")
@Entity
public class Group {

    @Id
    @GeneratedValue
    private Long id;
    //@NonNull // cant have null field
    private String name;
    private String address;
    private String city;
    private String state_Or_Province;
    private String country;
    private String postal_Code;

    public Group(){

    }

    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "group")
    @JsonIgnore
    private Set<Event> events;

    public Group(Long id, String name, String address, String city, String state_Or_Province, String country,
            String postal_Code) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state_Or_Province = state_Or_Province;
        this.country = country;
        this.postal_Code = postal_Code;
      
    }
}