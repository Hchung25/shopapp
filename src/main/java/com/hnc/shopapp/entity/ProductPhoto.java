package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ProductPhotos")
@Data
public class ProductPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoID;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer displayOrder;

    @Column(nullable = false)
    private Boolean isHidden;
}
