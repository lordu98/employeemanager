package com.example.employeemanager.service;

import com.example.employeemanager.entity.Employee;
import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public record EmployeeService(EmployeeRepo employeeRepo) {
    @Autowired
    public EmployeeService {
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Integer id) {
        return employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Employee not found"));
    }

    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);
    }

}
