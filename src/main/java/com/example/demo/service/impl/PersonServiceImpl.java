package com.example.demo.service.impl;

import com.example.demo.DTO.PersonDTO;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public List<PersonDTO> findAllPersons() {
        List<Person> personList = personRepository.findAll();
        List<PersonDTO> personDTOList = new ArrayList<>();
        for (Person person : personList) {
            personDTOList.add(toPersonDTO(person));
        }
        return personDTOList;
    }

    @Override
    public PersonDTO findPersonById(long id) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Person with id %s not found", id))
        );
        return toPersonDTO(person);
    }

    @Override
    public void deletePersonById(long id) {
        personRepository.deleteById(id);
    }

    public PersonDTO toPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFullName(person.getFullName());
        personDTO.setEmail(person.getEmail());
        personDTO.setPhoneNumber(person.getPhoneNumber());
        return personDTO;
    }

}
