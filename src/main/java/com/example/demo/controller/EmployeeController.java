package com.example.demo.controller;


import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
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
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = "http://localhost:63342")
// порт для фронта, потому что idea сама выбрала случайный порт для фронта
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/get-all-dto") // работает
    public List<EmployeeDTO> getEmployeesDTO() {
        return employeeService.findAllEmployeesDTO();
    }

    @GetMapping("/get-all") // работает
    public List<Employee> getEmployees() {
        return employeeService.findAllEmployees();
    }

    @PostMapping("/save_employee") // работает
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
}
