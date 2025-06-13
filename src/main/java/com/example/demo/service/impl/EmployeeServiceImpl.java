package com.example.demo.service.impl;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> findAllEmployeesDTO() {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            employeeDTOS.add(toDTO(employee));
        }
        return employeeDTOS;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    private EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFullName(employee.getFullName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setPosition(employee.getPosition());
        return employeeDTO;
    }
    // это ответственность сервиса обработать данные, которые пришли из репозитория
}
