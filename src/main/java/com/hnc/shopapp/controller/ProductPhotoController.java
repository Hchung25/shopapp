package com.hnc.shopapp.controller;

import com.hnc.shopapp.entity.ProductPhoto;
import com.hnc.shopapp.service.ProductPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-photos")
public class ProductPhotoController {
    @Autowired
    private ProductPhotoService productPhotoService;

    @GetMapping
    public List<ProductPhoto> getAll() { return productPhotoService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPhoto> getById(@PathVariable Long id) {
        return productPhotoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductPhoto create(@RequestBody ProductPhoto productPhoto) { return productPhotoService.save(productPhoto); }

    @PutMapping("/{id}")
    public ResponseEntity<ProductPhoto> update(@PathVariable Long id, @RequestBody ProductPhoto productPhoto) {
        if (!productPhotoService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        productPhoto.setPhotoID(id);
        return ResponseEntity.ok(productPhotoService.save(productPhoto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!productPhotoService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        productPhotoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
