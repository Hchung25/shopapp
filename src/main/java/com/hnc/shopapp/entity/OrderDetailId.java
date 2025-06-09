package com.hnc.shopapp.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class OrderDetailId implements Serializable {
    private Integer orderID;
    private Integer productID;
}
