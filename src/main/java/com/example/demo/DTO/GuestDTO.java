package com.example.demo.DTO;

import lombok.Getter;

@Getter
public class GuestDTO {
    private String fullName;
    private String email;
    private String phoneNumber;
    private Boolean isEmployee;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIsEmployee(Boolean isEmployee) {
        this.isEmployee = isEmployee;
    }
}
