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
@RequestMapping({ "/project" })
public class ProjectController {

	@Autowired
	ProjectService service;

	@Autowired
	SkillService skillService;

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<Project> listar() {
		return service.listar();
	}

	@GetMapping(value = "/{id}")
	public Optional<Project> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PostMapping
	public Project create(@RequestBody Project p) {
		if(p.getStartDate()==null) p.setStartDate(LocalDate.now());
		if(p.getEndDate()==null) p.setEndDate(LocalDate.now());
		return service.update(p);
	}

	@PutMapping(value = "/{id}")
	public Project edit(@RequestBody Project p, @PathVariable Integer id) {
		p.setId(id);
		return service.update(p);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@PostMapping(value = "/skill/{projectId}/{skillId}")
	public void addSkill(@PathVariable Integer projectId, @PathVariable Integer skillId) {
		Project pr = service.findById(projectId).get();
		Skill s = skillService.findById(skillId).get();

		List<Skill> projectSkills = pr.getProjectSkills();

		projectSkills.add(s);

		pr.setProjectSkills(projectSkills);

		service.update(pr);
	}

	@PostMapping(value = "/employee/{projectId}/{employeeId}")
	public void addEmployee(@PathVariable Integer projectId, @PathVariable Integer employeeId) {
		Project pr = service.findById(projectId).get();
		Employee s = employeeService.findById(employeeId).get();

		List<Employee> employeeList = pr.getEmployeeList();

		employeeList.add(s);

		pr.setEmployeeList(employeeList);

		service.update(pr);
	}
}
