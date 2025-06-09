package com.hnc.shopapp.service;

import com.hnc.shopapp.entity.Shipper;
import com.hnc.shopapp.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperService {
    @Autowired
    private ShipperRepository shipperRepository;

    public List<Shipper> getAll() { return shipperRepository.findAll(); }
    public Optional<Shipper> getById(Integer id) { return shipperRepository.findById(id); }
    public Shipper save(Shipper shipper) { return shipperRepository.save(shipper); }
    public void delete(Integer id) { shipperRepository.deleteById(id); }
}
