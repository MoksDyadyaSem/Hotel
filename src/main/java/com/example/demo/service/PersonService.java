package com.example.demo.service;

import com.example.demo.DTO.PersonDTO;
import com.example.demo.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    List<PersonDTO> findAllPersons();
    PersonDTO findPersonById(long id);
    void deletePersonById(long id);
}
