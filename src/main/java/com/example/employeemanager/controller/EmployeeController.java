package com.example.employeemanager.controller;

import com.example.employeemanager.entity.Employee;
import com.example.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public record EmployeeController(EmployeeService employeeService) {

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
        Employee employeeById = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employeeById, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
