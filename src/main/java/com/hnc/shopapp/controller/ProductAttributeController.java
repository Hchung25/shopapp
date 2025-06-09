package com.hnc.shopapp.controller;

import com.hnc.shopapp.entity.ProductAttribute;
import com.hnc.shopapp.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-attributes")
public class ProductAttributeController {
    @Autowired
    private ProductAttributeService productAttributeService;

    @GetMapping
    public List<ProductAttribute> getAll() { return productAttributeService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<ProductAttribute> getById(@PathVariable Long id) {
        return productAttributeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductAttribute create(@RequestBody ProductAttribute productAttribute) { return productAttributeService.save(productAttribute); }

    @PutMapping("/{id}")
    public ResponseEntity<ProductAttribute> update(@PathVariable Long id, @RequestBody ProductAttribute productAttribute) {
        if (!productAttributeService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        productAttribute.setAttributeID(id);
        return ResponseEntity.ok(productAttributeService.save(productAttribute));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!productAttributeService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        productAttributeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
