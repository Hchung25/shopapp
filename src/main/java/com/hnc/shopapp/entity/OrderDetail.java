package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderDetails")
@Data
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("orderID")
    @JoinColumn(name = "OrderID")
    private Order order;

    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name = "ProductID")
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    private Double salePrice;
}

