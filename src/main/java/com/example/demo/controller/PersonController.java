package com.example.demo.controller;

import com.example.demo.DTO.PersonDTO;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
@CrossOrigin(origins = "http://localhost:63342")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/get-all")
    public List<PersonDTO> getAllPersons() {
        return personService.findAllPersons();
    }

    @GetMapping("/get/{id}")
    public PersonDTO getPersonById(@PathVariable Long id) {
        return personService.findPersonById(id);
    }

    @DeleteMapping("/remove/{id}")
    public void deletePersonById(@PathVariable Long id) {
        personService.deletePersonById(id);
    }
}
