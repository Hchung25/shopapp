package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @Column(nullable = false)
    private LocalDateTime orderTime;

    private String deliveryProvince;
    private String deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "EmployeeID")
    private Employee employee;

    private LocalDateTime acceptTime;

    @ManyToOne
    @JoinColumn(name = "ShipperID")
    private Shipper shipper;

    private LocalDateTime shippedTime;
    private LocalDateTime finishedTime;

    @ManyToOne
    @JoinColumn(name = "Status")
    private OrderStatus status;
}
