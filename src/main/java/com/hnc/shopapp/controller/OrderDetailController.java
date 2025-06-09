package com.hnc.shopapp.controller;

import com.hnc.shopapp.entity.OrderDetail;
import com.hnc.shopapp.entity.OrderDetailId;
import com.hnc.shopapp.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public List<OrderDetail> getAll() { return orderDetailService.getAll(); }

    @GetMapping("/{orderId}/{productId}")
    public ResponseEntity<OrderDetail> getById(@PathVariable Integer orderId, @PathVariable Integer productId) {
        OrderDetailId id = new OrderDetailId();
        id.setOrderID(orderId);
        id.setProductID(productId);
        return orderDetailService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderDetail create(@RequestBody OrderDetail orderDetail) { return orderDetailService.save(orderDetail); }

    @PutMapping("/{orderId}/{productId}")
    public ResponseEntity<OrderDetail> update(@PathVariable Integer orderId, @PathVariable Integer productId, @RequestBody OrderDetail orderDetail) {
        OrderDetailId id = new OrderDetailId();
        id.setOrderID(orderId);
        id.setProductID(productId);
        if (!orderDetailService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        orderDetail.setId(id);
        return ResponseEntity.ok(orderDetailService.save(orderDetail));
    }

    @DeleteMapping("/{orderId}/{productId}")
    public ResponseEntity<Void> delete(@PathVariable Integer orderId, @PathVariable Integer productId) {
        OrderDetailId id = new OrderDetailId();
        id.setOrderID(orderId);
        id.setProductID(productId);
        if (!orderDetailService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        orderDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
