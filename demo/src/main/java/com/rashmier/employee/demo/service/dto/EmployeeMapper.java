package com.rashmier.employee.demo.service.dto;

import com.rashmier.employee.demo.model.Employee;

public class EmployeeMapper {

    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeNo(employee.getEmployeeNo());
        dto.setTitle(employee.getTitle());
        dto.setFirstname(employee.getFirstname());
        dto.setSurname(employee.getSurname());
        dto.setDob(employee.getDob());
        dto.setGender(employee.getGender());
        dto.setEmail(employee.getEmail());
        dto.setAddress(employee.getAddress());
        return dto;
    }

    public static Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setEmployeeNo(dto.getEmployeeNo());
        employee.setTitle(dto.getTitle());
        employee.setFirstname(dto.getFirstname());
        employee.setSurname(dto.getSurname());
        employee.setDob(dto.getDob());
        employee.setGender(dto.getGender());
        employee.setEmail(dto.getEmail());
        employee.setAddress(dto.getAddress());
        return employee;
    }
}
