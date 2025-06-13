package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
public class Guest extends Person {
    @Getter
    @Column
    private Boolean isEmployee;

    @OneToOne(mappedBy = "guest")
    private Service service;

}
