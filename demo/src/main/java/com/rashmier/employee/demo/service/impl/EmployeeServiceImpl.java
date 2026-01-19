package com.rashmier.employee.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rashmier.employee.demo.controller.api.CustomApiResponse;
import com.rashmier.employee.demo.model.Employee;
import com.rashmier.employee.demo.repository.EmployeeRepository;
import com.rashmier.employee.demo.service.BaseCRUDService;
import com.rashmier.employee.demo.service.dto.EmployeeDTO;
import com.rashmier.employee.demo.service.dto.EmployeeMapper;
import com.rashmier.employee.demo.service.dto.EmployeePatchDTO;

@Service
public class EmployeeServiceImpl implements BaseCRUDService<EmployeeDTO, Long, EmployeePatchDTO> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public CustomApiResponse<EmployeeDTO> create(EmployeeDTO dto) {

        if (employeeRepository.existsByEmail(dto.getEmail())) {
            return CustomApiResponse.error(HttpStatus.CONFLICT, "Email already exists");
        }

        Employee saved = employeeRepository.save(
                EmployeeMapper.toEntity(dto)
        );

        return CustomApiResponse.created(
                "Employee created successfully",
                EmployeeMapper.toDTO(saved)
        );
    }

    @Override
    public CustomApiResponse<EmployeeDTO> findById(Long id) {
        return employeeRepository.findById(id)
                .map(emp -> CustomApiResponse.success(
                        "Employee found",
                        EmployeeMapper.toDTO(emp)))
                .orElse(CustomApiResponse.error(
                        HttpStatus.NOT_FOUND,
                        "Employee not found"));
    }

    @Override
    public CustomApiResponse<List<EmployeeDTO>> findAll() {

        List<EmployeeDTO> list = employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());

        return CustomApiResponse.success("Employee list retrieved", list);
    }

    @Override
    public CustomApiResponse<EmployeeDTO> update(Long id, EmployeeDTO dto) {
    }

    @Override
    public CustomApiResponse<Void> delete(Long id) {

        if (!employeeRepository.existsById(id)) {
            return CustomApiResponse.error(HttpStatus.NOT_FOUND, "Employee not found");
        }

        employeeRepository.deleteById(id);
        return CustomApiResponse.success("Employee deleted successfully", null);
    }
    
    @Override
    public CustomApiResponse<EmployeeDTO> patch(Long id, EmployeePatchDTO dto) {
    }
    
    public CustomApiResponse<Boolean> verifyEmail(String email) {

        if (email == null || email.isBlank()) {
            return CustomApiResponse.error(
                    HttpStatus.BAD_REQUEST,
                    "Email must not be empty"
            );
        }

        boolean exists = employeeRepository.existsByEmail(email);

        if (exists) {
            return CustomApiResponse.error(
                    HttpStatus.CONFLICT,
                    "Email is already taken"
            );
        }

        return CustomApiResponse.success(
                "Email is valid and available",
                true
        );
    }
}