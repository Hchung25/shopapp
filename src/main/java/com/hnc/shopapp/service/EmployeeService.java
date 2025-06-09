package com.hnc.shopapp.service;

import com.hnc.shopapp.entity.Employee;
import com.hnc.shopapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() { return employeeRepository.findAll(); }
    public Optional<Employee> getById(Integer id) { return employeeRepository.findById(id); }
    public Employee save(Employee employee) { return employeeRepository.save(employee); }
    public void delete(Integer id) { employeeRepository.deleteById(id); }
}
