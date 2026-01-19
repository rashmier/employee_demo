package com.rashmier.employee.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rashmier.employee.demo.controller.api.CustomApiResponse;
import com.rashmier.employee.demo.service.dto.EmployeeDTO;
import com.rashmier.employee.demo.service.dto.EmployeePatchDTO;
import com.rashmier.employee.demo.service.impl.EmployeeServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee API", description = "CRUD operations for Employee")
public class EmployeeController {

	@Autowired
    private EmployeeServiceImpl employeeService;

    @Operation(summary = "Create a new employee",
        responses = {
            @ApiResponse(responseCode = "201", description = "Employee created"),
            @ApiResponse(responseCode = "400", description = "Validation error"),
            @ApiResponse(responseCode = "409", description = "Email already exists")
        }
    )
    @PostMapping
    public ResponseEntity<CustomApiResponse<EmployeeDTO>> create(
            @RequestBody EmployeeDTO dto) {
        CustomApiResponse<EmployeeDTO> response = employeeService.create(dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(summary = "Get employee by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CustomApiResponse<EmployeeDTO>> getById(@PathVariable Long id) {
    	CustomApiResponse<EmployeeDTO> response = employeeService.findById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(summary = "Get all employees")
    @GetMapping
    public ResponseEntity<CustomApiResponse<List<EmployeeDTO>>> getAll() {
    	CustomApiResponse<List<EmployeeDTO>> response = employeeService.findAll();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @Operation(summary = "Update an existing employee")
    @PutMapping("/{id}")
    public ResponseEntity<CustomApiResponse<EmployeeDTO>> update(
            @PathVariable Long id,
            @RequestBody EmployeeDTO dto) {
    	CustomApiResponse<EmployeeDTO> response = employeeService.update(id, dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    
    @Operation(summary = "Delete an employee")
    @ApiResponse(responseCode = "204", description = "Employee deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomApiResponse<Void>> delete(@PathVariable Long id) {
    	CustomApiResponse<Void> response = employeeService.delete(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    
    @Operation(summary = "Verify an email for an Employee",
		responses = {
            @ApiResponse(responseCode = "200", description = "Email created"),
            @ApiResponse(responseCode = "400", description = "Email Validation error"),
            @ApiResponse(responseCode = "409", description = "Email already exists")
        }
    )
    @GetMapping("/verifyEmail")
    public ResponseEntity<CustomApiResponse<Boolean>> verifyEmail(
            @RequestParam String email) {
    	CustomApiResponse<Boolean> response = employeeService.verifyEmail(email);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    
    @Operation(summary = "Patch Employee information")
    @PatchMapping("/{id}")
    public ResponseEntity<CustomApiResponse<EmployeeDTO>> patchEmployee(
            @PathVariable Long id,
            @RequestBody EmployeePatchDTO dto) {

    	CustomApiResponse<EmployeeDTO> response = employeeService.patch(id, dto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}