package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerID;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String contactName;

    private String province;
    private String address;
    private String phone;
    private String email;
    private String password;
    private Boolean isLocked;
}
