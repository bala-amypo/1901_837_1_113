package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }

    // Setters
    public void setName(String name) { this.name = name; }
}
