package com.hnc.shopapp.controller;


import com.hnc.shopapp.entity.Category;
import com.hnc.shopapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAll() { return categoryService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Integer id) {
        return categoryService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Category create(@RequestBody Category category) { return categoryService.save(category); }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category category) {
        if (!categoryService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        category.setCategoryID(id);
        return ResponseEntity.ok(categoryService.save(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!categoryService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
