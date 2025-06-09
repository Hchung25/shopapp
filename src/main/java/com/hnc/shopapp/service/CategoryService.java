package com.hnc.shopapp.service;


import com.hnc.shopapp.entity.Category;
import com.hnc.shopapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() { return categoryRepository.findAll(); }
    public Optional<Category> getById(Integer id) { return categoryRepository.findById(id); }
    public Category save(Category category) { return categoryRepository.save(category); }
    public void delete(Integer id) { categoryRepository.deleteById(id); }
}
