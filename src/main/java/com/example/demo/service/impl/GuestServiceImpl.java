package com.example.demo.service.impl;

import com.example.demo.DTO.GuestDTO;
import com.example.demo.entity.Guest;
import com.example.demo.repository.GuestRepository;
import com.example.demo.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    @Override
    public List<GuestDTO> findAllGuests() {

        List<Guest> guests = guestRepository.findAll();

        List<GuestDTO> guestDTOS = new ArrayList<>();

        for (Guest guest : guests) {
            guestDTOS.add(toDTO(guest));
        }

        return guestDTOS;
    }

    @Override
    public void saveGuest(Guest guest) {
        guestRepository.save(guest);
    }

    @Override
    public Guest findGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    private GuestDTO toDTO(Guest guest) {
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setFullName(guest.getFullName());
        guestDTO.setEmail(guest.getEmail());
        guestDTO.setPhoneNumber(guest.getPhoneNumber());
        guestDTO.setIsEmployee(guest.getIsEmployee());

        return guestDTO;
    }
}
