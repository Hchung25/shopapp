package com.hnc.shopapp.controller;

import com.hnc.shopapp.entity.Shipper;
import com.hnc.shopapp.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shippers")
public class ShipperController {
    @Autowired
    private ShipperService shipperService;

    @GetMapping
    public List<Shipper> getAll() { return shipperService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Shipper> getById(@PathVariable Integer id) {
        return shipperService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Shipper create(@RequestBody Shipper shipper) { return shipperService.save(shipper); }

    @PutMapping("/{id}")
    public ResponseEntity<Shipper> update(@PathVariable Integer id, @RequestBody Shipper shipper) {
        if (!shipperService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        shipper.setShipperID(id);
        return ResponseEntity.ok(shipperService.save(shipper));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!shipperService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        shipperService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
