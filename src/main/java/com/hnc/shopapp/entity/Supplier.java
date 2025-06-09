package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Suppliers")
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierID;

    @Column(nullable = false)
    private String supplierName;

    @Column(nullable = false)
    private String contactName;

    private String provice;
    private String address;
    private String phone;
    private String email;
}
