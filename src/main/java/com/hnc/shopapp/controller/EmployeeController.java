package com.hnc.shopapp.controller;

import com.hnc.shopapp.entity.Employee;
import com.hnc.shopapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() { return employeeService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Integer id) {
        return employeeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) { return employeeService.save(employee); }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody Employee employee) {
        if (!employeeService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        employee.setEmployeeID(id);
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!employeeService.getById(id).isPresent()) return ResponseEntity.notFound().build();
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
