package com.hnc.shopapp.service;

import com.hnc.shopapp.entity.Supplier;
import com.hnc.shopapp.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAll() { return supplierRepository.findAll(); }
    public Optional<Supplier> getById(Integer id) { return supplierRepository.findById(id); }
    public Supplier save(Supplier supplier) { return supplierRepository.save(supplier); }
    public void delete(Integer id) { supplierRepository.deleteById(id); }
}
