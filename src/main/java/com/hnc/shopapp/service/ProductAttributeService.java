package com.hnc.shopapp.service;

import com.hnc.shopapp.entity.ProductAttribute;
import com.hnc.shopapp.repository.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductAttributeService {
    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    public List<ProductAttribute> getAll() { return productAttributeRepository.findAll(); }
    public Optional<ProductAttribute> getById(Long id) { return productAttributeRepository.findById(id); }
    public ProductAttribute save(ProductAttribute productAttribute) { return productAttributeRepository.save(productAttribute); }
    public void delete(Long id) { productAttributeRepository.deleteById(id); }
}
