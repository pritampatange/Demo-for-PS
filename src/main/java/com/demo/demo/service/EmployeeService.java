package com.demo.demo.service;


import com.demo.demo.entity.Employee;
import com.demo.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee create(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee update(Long id, Employee emp) {
        Employee existing = getById(id);
        existing.setName(emp.getName());
        existing.setCompany(emp.getCompany());

        return repo.save(existing);
    }

    public void delete(Long id) {
        Employee existing = getById(id);
        repo.delete(existing);
    }
}