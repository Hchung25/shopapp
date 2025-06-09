package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeID;

    @Column(nullable = false)
    private String fullName;

    private LocalDate birthDate;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String photo;
    private Boolean isWorking;

    @Column(nullable = false)
    private String role;
}
