package com.hnc.shopapp.controller;

import com.hnc.shopapp.entity.OrderStatus;
import com.hnc.shopapp.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-status")
public class OrderStatusController {
    @Autowired
    private OrderStatusService orderStatusService;

    @GetMapping
    public List<OrderStatus> getAll() { return orderStatusService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<OrderStatus> getById(@PathVariable Integer id) {
        return orderStatusService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderStatus create(@RequestBody OrderStatus orderStatus) { return orderStatusService.save(orderStatus); }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStatus> update(@PathVariable Integer id, @RequestBody OrderStatus orderStatus) {
        if (!orderStatusService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        orderStatus.setStatus(id);
        return ResponseEntity.ok(orderStatusService.save(orderStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!orderStatusService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        orderStatusService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
