package com.hnc.shopapp.service;

import com.hnc.shopapp.entity.Order;
import com.hnc.shopapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() { return orderRepository.findAll(); }
    public Optional<Order> getById(Integer id) { return orderRepository.findById(id); }
    public Order save(Order order) { return orderRepository.save(order); }
    public void delete(Integer id) { orderRepository.deleteById(id); }
}
