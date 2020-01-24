package com.ejemplo01.controller;

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
@RequestMapping({ "/skill" })
public class SkillController {

	@Autowired
	SkillService service;

	@Autowired
	ProjectService projectService;

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<Skill> listar() {
		return service.listar();
	}

	@GetMapping(value = "/{id}")
	public Optional<Skill> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PostMapping
	public Skill create(@RequestBody Skill p) {
		return service.update(p);
	}

	@PutMapping(value = "/{id}")
	public Skill edit(@RequestBody Skill p, @PathVariable Integer id) {
		p.setId(id);
		return service.update(p);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}

	@PostMapping(value = "/project/{skillId}/{projectId}")
	public void addProject(@PathVariable Integer skillId, @PathVariable Integer projectId) {
		Skill s = service.findById(skillId).get();
		Project pr = projectService.findById(projectId).get();

		List<Project> skillProjects = s.getProjectList();

		if (!skillProjects.contains(pr)) {
			skillProjects.add(pr);
			s.setProjectList(skillProjects);
			service.update(s);
		}
	}

	@PostMapping(value = "/employee/{skillId}/{employeeId}")
	public void addEmployee(@PathVariable Integer skillId, @PathVariable Integer employeeId) {
		Skill s = service.findById(skillId).get();
		Employee pr = employeeService.findById(employeeId).get();

		List<Employee> skillEmployees = s.getEmployeeList();

		if (!skillEmployees.contains(pr)) {
			skillEmployees.add(pr);
			s.setEmployeeList(skillEmployees);
			service.update(s);
		}
	}
}
