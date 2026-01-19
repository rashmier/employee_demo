package com.rashmier.employee.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rashmier.employee.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmail(String email);
}