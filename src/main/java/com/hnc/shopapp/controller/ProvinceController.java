package com.hnc.shopapp.controller;

import com.hnc.shopapp.entity.Province;
import com.hnc.shopapp.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping
    public List<Province> getAll() { return provinceService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getById(@PathVariable String id) {
        return provinceService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Province create(@RequestBody Province province) { return provinceService.save(province); }

    @PutMapping("/{id}")
    public ResponseEntity<Province> update(@PathVariable String id, @RequestBody Province province) {
        if (!provinceService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        province.setProvinceName(id);
        return ResponseEntity.ok(provinceService.save(province));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!provinceService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        provinceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
