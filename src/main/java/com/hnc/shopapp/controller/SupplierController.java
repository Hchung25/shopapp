package com.hnc.shopapp.controller;

import com.hnc.shopapp.entity.Supplier;
import com.hnc.shopapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAll() { return supplierService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable Integer id) {
        return supplierService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) { return supplierService.save(supplier); }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> update(@PathVariable Integer id, @RequestBody Supplier supplier) {
        if (!supplierService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        supplier.setSupplierID(id);
        return ResponseEntity.ok(supplierService.save(supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!supplierService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
