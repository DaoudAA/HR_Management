package com.papillon.rhmanagement.contoller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papillon.rhmanagement.model.Employee;
import com.papillon.rhmanagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmpoyeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable UUID id){
        return employeeService.getDetailsEmployee(id);
    }

    @PostMapping
    public Employee addEmployee(Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable UUID id, @RequestBody Employee personDetails) {
        return employeeService.updateEmployee(id, personDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
    }
    
}
