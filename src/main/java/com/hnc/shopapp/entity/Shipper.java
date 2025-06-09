package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Shippers")
@Data
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shipperID;

    @Column(nullable = false)
    private String shipperName;

    private String phone;
}
