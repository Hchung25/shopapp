package com.hnc.shopapp.service;

import com.hnc.shopapp.entity.ProductPhoto;
import com.hnc.shopapp.repository.ProductPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPhotoService {
    @Autowired
    private ProductPhotoRepository productPhotoRepository;

    public List<ProductPhoto> getAll() { return productPhotoRepository.findAll(); }
    public Optional<ProductPhoto> getById(Long id) { return productPhotoRepository.findById(id); }
    public ProductPhoto save(ProductPhoto productPhoto) { return productPhotoRepository.save(productPhoto); }
    public void delete(Long id) { productPhotoRepository.deleteById(id); }
}
