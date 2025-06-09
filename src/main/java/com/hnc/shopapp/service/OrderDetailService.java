package com.hnc.shopapp.service;


import com.hnc.shopapp.entity.OrderDetail;
import com.hnc.shopapp.entity.OrderDetailId;
import com.hnc.shopapp.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getAll() { return orderDetailRepository.findAll(); }
    public Optional<OrderDetail> getById(OrderDetailId id) { return orderDetailRepository.findById(id); }
    public OrderDetail save(OrderDetail orderDetail) { return orderDetailRepository.save(orderDetail); }
    public void delete(OrderDetailId id) { orderDetailRepository.deleteById(id); }
}
