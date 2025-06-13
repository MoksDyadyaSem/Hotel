package com.example.demo.controller;

import com.example.demo.DTO.GuestDTO;
import com.example.demo.entity.Guest;
import com.example.demo.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/guest")
@CrossOrigin(origins = "http://localhost:63342")
// порт для фронта, потому что idea сама выбрала случайный порт для фронта
public class GuestController {

    private final GuestService guestService;

    @GetMapping("/get-all")
    public List<GuestDTO> getAll() {
        return guestService.findAllGuests();
    }

    @PostMapping("save_guest")
    public ResponseEntity<?> saveGuest(@RequestBody Guest guest) {
        guestService.saveGuest(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(guest);
    }


}
