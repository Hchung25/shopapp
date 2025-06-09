package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ProductAttributes")
@Data
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attributeID;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(nullable = false)
    private String attributeName;

    @Column(nullable = false, columnDefinition = "nvarchar(max)")
    private String attributeValue;

    @Column(nullable = false)
    private Integer displayOrder;
}
