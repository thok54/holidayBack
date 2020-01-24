package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo01.entity.Employee;

public interface EmployeeService {
	List<Employee> listar();

	Optional<Employee> findById(Integer id);

	Employee update(Employee p);

	void deleteById(Integer id);
}
