package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Guest extends Person {
    @Getter
    @Column
    private Boolean isEmployee;

    @JsonIgnore
    @OneToOne(mappedBy = "guest")
    private Service service;

    @JsonIgnore
    @OneToOne(mappedBy = "guest")
    private Reservation reservation;
}
