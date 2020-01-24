package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo01.entity.EmployeeProjectPeriod;
import com.ejemplo01.repo.EmployeeProjectPeriodRepository;

@Service
public class EmployeeProjectPeriodServiceImp implements EmployeeProjectPeriodService {
	@Autowired
	private EmployeeProjectPeriodRepository repository;

	@Override
	public List<EmployeeProjectPeriod> listar() {
		return repository.findAll();
	}

	@Override
	public Optional<EmployeeProjectPeriod> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public EmployeeProjectPeriod update(EmployeeProjectPeriod p) {
		return repository.save(p);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
