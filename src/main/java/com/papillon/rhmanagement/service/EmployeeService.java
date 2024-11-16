package com.papillon.rhmanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papillon.rhmanagement.model.Employee;
import com.papillon.rhmanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    void addEmployee(){

    }
    public Optional<Employee> getDetailsEmployee(UUID id){
        return employeeRepository.findById(id);
        
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(UUID id, Employee EmployeeDetails) {
        Employee Employee = employeeRepository.findById(id).orElseThrow();
        Employee.setName(EmployeeDetails.getName());
        Employee.setSurname(EmployeeDetails.getSurname());
        Employee.setPosition(EmployeeDetails.getPosition());
        Employee.setSalary(EmployeeDetails.getSalary());
        Employee.setDepartement(EmployeeDetails.getDepartement());
        return employeeRepository.save(Employee);
    }
    
}
