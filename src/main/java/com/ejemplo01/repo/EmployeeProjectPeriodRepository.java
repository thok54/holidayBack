package com.ejemplo01.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ejemplo01.entity.EmployeeProjectPeriod;

@RepositoryRestResource(path = "employeeProjectPeriodTree", collectionResourceRel = "employeeProjectPeriodTree")
public interface EmployeeProjectPeriodRepository extends PagingAndSortingRepository<EmployeeProjectPeriod, Integer> {
	List<EmployeeProjectPeriod> findAll();

	Optional<EmployeeProjectPeriod> findById(Integer id);

	EmployeeProjectPeriod save(EmployeeProjectPeriod p);

	void deleteById(Integer id);
}