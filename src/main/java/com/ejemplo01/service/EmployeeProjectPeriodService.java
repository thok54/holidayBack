package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo01.entity.EmployeeProjectPeriod;

public interface EmployeeProjectPeriodService {
	List<EmployeeProjectPeriod> listar();

	Optional<EmployeeProjectPeriod> findById(Integer id);

	EmployeeProjectPeriod update(EmployeeProjectPeriod p);

	void deleteById(Integer id);

}
