package com.example.demo.controller;

import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/get-all")
    public List<Reservation> getAllReservations() {
        return reservationService.getReservations();
    }

    @GetMapping("/get/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservation(id);
    }
}
