package com.hnc.shopapp.service;

import com.hnc.shopapp.entity.OrderStatus;
import com.hnc.shopapp.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public List<OrderStatus> getAll() { return orderStatusRepository.findAll(); }
    public Optional<OrderStatus> getById(Integer id) { return orderStatusRepository.findById(id); }
    public OrderStatus save(OrderStatus orderStatus) { return orderStatusRepository.save(orderStatus); }
    public void delete(Integer id) { orderStatusRepository.deleteById(id); }
}
