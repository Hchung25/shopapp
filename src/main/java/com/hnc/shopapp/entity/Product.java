package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productID;

    @Column(nullable = false)
    private String productName;

    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private Double price;

    private String photo;
    private Boolean isSelling;
}
