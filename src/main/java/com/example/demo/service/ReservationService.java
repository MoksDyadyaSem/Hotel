package com.example.demo.service;

import com.example.demo.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    List<Reservation> getReservations();
    Reservation getReservation(Long id);
}
