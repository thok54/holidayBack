package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo01.entity.Project;

public interface ProjectService {
	List<Project> listar();

	Optional<Project> findById(Integer id);

	Project update(Project p);

	void deleteById(Integer id);

}
