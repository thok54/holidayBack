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

import com.ejemplo01.entity.Absence;
import com.ejemplo01.service.AbsenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/absence" })
public class AbsenceController {

	@Autowired
	AbsenceService service;

	@GetMapping
	public List<Absence> listar() {
		return service.listar();
	}

	@GetMapping(value = "/{id}")
	public Optional<Absence> findById(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PostMapping
	public Absence create(@RequestBody Absence p) {
		if(p.getStartDate()==null) p.setStartDate(LocalDate.now());
		if(p.getEndDate()==null) p.setEndDate(LocalDate.now());
		return service.update(p);
	}
	
	@PutMapping(value = "/{id}")
	public Absence edit(@RequestBody Absence p,@PathVariable Integer id) {
		p.setId(id);
		return service.update(p);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}
}
