package com.hnc.shopapp.repository;


import com.hnc.shopapp.entity.OrderDetail;
import com.hnc.shopapp.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {}
