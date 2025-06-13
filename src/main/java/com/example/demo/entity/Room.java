package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "price_per_day", nullable = false)
    private int pricePerDay;

    @Column(name = "rating")
    private double rating;

    @Column(name = "number_of_beds", nullable = false)
    private int numberOfBeds;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "availability")
    private boolean availability;
}
