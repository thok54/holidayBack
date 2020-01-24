package com.ejemplo01.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo01.entity.Employee;
import com.ejemplo01.entity.EmployeeProjectPeriod;
import com.ejemplo01.entity.Project;
import com.ejemplo01.service.EmployeeProjectPeriodService;
import com.ejemplo01.service.EmployeeService;
import com.ejemplo01.service.ProjectService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employee_project_period" })
public class EmployeeProjectPeriodController {

	@Autowired
	EmployeeProjectPeriodService service;

	@Autowired
	EmployeeService empService;

	@Autowired
	ProjectService projectService;

	@GetMapping
	public List<EmployeeProjectPeriod> listar() {
		return service.listar();
	}

	@GetMapping(value = "/{id}")
	public Optional<EmployeeProjectPeriod> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PostMapping
	public EmployeeProjectPeriod create(@RequestBody EmployeeProjectPeriod p) {
		if (p.getStartDate() == null)
			p.setStartDate(LocalDate.now());
		if (p.getEndDate() == null)
			p.setEndDate(LocalDate.now());
		EmployeeProjectPeriod epp = service.update(p);
		addToRelation(epp.getIdEmployee(), epp.getIdProject());
		return epp;
	}

	@PutMapping(value = "/{id}")
	public EmployeeProjectPeriod edit(@RequestBody EmployeeProjectPeriod p, @PathVariable Integer id) {
		p.setId(id);
		EmployeeProjectPeriod epp = service.update(p);
		addToRelation(epp.getIdEmployee(), epp.getIdProject());
		return epp;
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@PostMapping(value = "/{employeeId}/{projectId}")
	public void addToRelation(@PathVariable Integer employeeId, @PathVariable Integer projectId) {
		Employee pr = empService.findById(employeeId).get();
		Project s = projectService.findById(projectId).get();

		List<Project> projectList = pr.getProjectList();
		if (!projectList.contains(s)) {
			projectList.add(s);
			pr.setProjectList(projectList);
			empService.update(pr);
		}

		List<Employee> employeeList = s.getEmployeeList();
		if (!employeeList.contains(pr)) {
			employeeList.add(pr);
			s.setEmployeeList(employeeList);
			projectService.update(s);
		}
	}
}
