package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo01.entity.Employee;
import com.ejemplo01.repo.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> listar() {
		return repository.findAll();
	}

	@Override
	public Optional<Employee> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Employee update(Employee p) {
		return repository.save(p);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}
