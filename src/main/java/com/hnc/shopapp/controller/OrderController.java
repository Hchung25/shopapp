package com.hnc.shopapp.controller;

import com.hnc.shopapp.entity.Order;
import com.hnc.shopapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll() { return orderService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Integer id) {
        return orderService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Order create(@RequestBody Order order) { return orderService.save(order); }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Integer id, @RequestBody Order order) {
        if (!orderService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        order.setOrderID(id);
        return ResponseEntity.ok(orderService.save(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!orderService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
