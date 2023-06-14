package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Customer() {

    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', password='%s']",
                id, name, password);
    }
}
