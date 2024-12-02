package com.papillon.rhmanagement.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.papillon.rhmanagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID>{

    
} 