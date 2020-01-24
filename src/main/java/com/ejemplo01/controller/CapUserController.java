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

import com.ejemplo01.entity.CapUser;
import com.ejemplo01.service.CapUserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/cap_user" })
public class CapUserController {

	@Autowired
	CapUserService service;

	@GetMapping
	public List<CapUser> listar() {
		return service.listar();
	}

	@GetMapping(value = "/{id}")
	public Optional<CapUser> findById(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@GetMapping(value = "/email/{email}")
	public CapUser findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}

	@PostMapping
	public CapUser add(@RequestBody CapUser p) {
		return service.update(p);
	}

	@PutMapping(value = "/{id}")
	public CapUser edit(@RequestBody CapUser p, @PathVariable Integer id) {
		p.setId(id);
		return service.update(p);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		service.deleteById(id);
	}

}
