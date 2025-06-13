package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "guest_id")
    private Guest guestId;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    @Column(name = "date_in")
    private LocalDate dateIn;

    @Column(name = "date_out")
    private LocalDate dateOut;

    @Column(name = "total_price")
    private int totalPrice;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room roomId;
}
