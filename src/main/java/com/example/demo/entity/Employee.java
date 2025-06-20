package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee extends Person {
    @Column(nullable = false)
    private String position;

    @JsonIgnore
    @OneToOne(mappedBy = "employee")
    private Service service;

    @JsonIgnore
    @OneToOne(mappedBy = "employee")
    private Reservation reservation;

    public Employee() {
    }

    public Employee(String fullName, String phoneNumber, String email, String position) {
        super(fullName, phoneNumber, email);
        this.position = position;
    }
}
