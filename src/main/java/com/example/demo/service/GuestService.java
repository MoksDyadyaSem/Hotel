package com.example.demo.service;

import com.example.demo.DTO.GuestDTO;
import com.example.demo.entity.Guest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GuestService {
    List<GuestDTO> findAllGuests();

    void saveGuest(Guest guest);

    Guest findGuestById(Long id);
}
