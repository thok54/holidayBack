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
import com.ejemplo01.entity.Project;
import com.ejemplo01.entity.Skill;
import com.ejemplo01.service.EmployeeService;
import com.ejemplo01.service.ProjectService;
import com.ejemplo01.service.SkillService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employee" })
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@Autowired
	SkillService skillService;

	@Autowired
	ProjectService projectService;

	@GetMapping
	public List<Employee> listar() {
		return service.listar();
	}

	@GetMapping(value = "/{id}")
	public Optional<Employee> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PostMapping
	public Employee create(@RequestBody Employee p) {
		if(p.getHireDate()==null) p.setHireDate(LocalDate.now());
		return service.update(p);
	}

	@PutMapping(value = "/{id}")
	public Employee edit(@RequestBody Employee p, @PathVariable Integer id) {
		p.setId(id);
		return service.update(p);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@PostMapping(value = "/skill/{employeeId}/{skillId}")
	public void addSkill(@PathVariable Integer employeeId, @PathVariable Integer skillId) {
		Employee pr = service.findById(employeeId).get();
		Skill s = skillService.findById(skillId).get();

		List<Skill> employeeSkills = pr.getEmployeeSkills();

		employeeSkills.add(s);

		pr.setEmployeeSkills(employeeSkills);

		service.update(pr);
	}

	@PostMapping(value = "/project/{employeeId}/{projectId}")
	public void addProject(@PathVariable Integer employeeId, @PathVariable Integer projectId) {
		Employee pr = service.findById(employeeId).get();
		Project s = projectService.findById(projectId).get();

		List<Project> projectList = pr.getProjectList();

		projectList.add(s);

		pr.setProjectList(projectList);

		service.update(pr);
	}
}
