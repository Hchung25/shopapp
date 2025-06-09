package com.hnc.shopapp.service;

import com.hnc.shopapp.entity.Province;
import com.hnc.shopapp.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    public List<Province> getAll() { return provinceRepository.findAll(); }
    public Optional<Province> getById(String id) { return provinceRepository.findById(id); }
    public Province save(Province province) { return provinceRepository.save(province); }
    public void delete(String id) { provinceRepository.deleteById(id); }
}
