package com.hnc.shopapp.repository;

import com.hnc.shopapp.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {}
