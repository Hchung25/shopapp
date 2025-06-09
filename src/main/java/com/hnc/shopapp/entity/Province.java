package com.hnc.shopapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Provinces")
@Data
public class Province {
    @Id
    private String provinceName;
}
