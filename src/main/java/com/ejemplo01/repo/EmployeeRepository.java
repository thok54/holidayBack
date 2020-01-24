package com.ejemplo01.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ejemplo01.entity.Employee;

@RepositoryRestResource(path = "employeeTree", collectionResourceRel = "employeeTree")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
	List<Employee> findAll();

	Optional<Employee> findById(Integer id);

	Employee save(Employee p);

	void deleteById(Integer id);
}