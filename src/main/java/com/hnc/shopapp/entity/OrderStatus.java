package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderStatus")
@Data
public class OrderStatus {
    @Id
    private Integer status;

    @Column(nullable = false)
    private String description;
}
