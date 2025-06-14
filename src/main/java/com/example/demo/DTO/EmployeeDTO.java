package com.example.demo.DTO;

import com.example.demo.entity.Reservation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String position;
    private Reservation reservation;
}
