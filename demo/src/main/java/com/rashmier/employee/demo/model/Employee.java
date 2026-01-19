package com.rashmier.employee.demo.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employee", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
@Schema(description = "Employee entity")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_no")
	@Schema(description = "Auto-generated employee number", example = "1001", accessMode = Schema.AccessMode.READ_ONLY)
	private Long employeeNo;

	@NotBlank
	@Schema(example = "Mr")
	private String title;

	@NotBlank
	@Schema(example = "John")
	private String firstname;

	@NotBlank
	@Schema(example = "Doe")
	private String surname;

	@NotNull
	@Schema(example = "1995-05-10")
	private LocalDate dob;

	@NotBlank
	@Schema(example = "Male")
	private String gender;

	@Email
	@NotBlank
	@Schema(example = "john.doe@email.com")
	private String email;

	@NotBlank
	@Schema(example = "Manila, Philippines")
	private String address;

	public Employee(String title, String firstname, String surname, LocalDate dob, String gender, String email,
			String address) {
		this.title = title;
		this.firstname = firstname;
		this.surname = surname;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.address = address;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public void update(Employee updated) {
		this.title = updated.title;
		this.firstname = updated.firstname;
		this.surname = updated.surname;
		this.dob = updated.dob;
		this.gender = updated.gender;
		this.email = updated.email;
		this.address = updated.address;
	}

	public Long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
