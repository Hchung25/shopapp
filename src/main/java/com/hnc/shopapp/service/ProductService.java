package com.hnc.shopapp.service;

import com.hnc.shopapp.entity.Product;
import com.hnc.shopapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() { return productRepository.findAll(); }
    public Optional<Product> getById(Integer id) { return productRepository.findById(id); }
    public Product save(Product product) { return productRepository.save(product); }
    public void delete(Integer id) { productRepository.deleteById(id); }
}
