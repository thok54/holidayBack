package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo01.entity.Project;
import com.ejemplo01.repo.ProjectRepository;

@Service
public class ProjectServiceImp implements ProjectService {
	@Autowired
	private ProjectRepository repository;

	@Override
	public List<Project> listar() {
		return repository.findAll();
	}

	@Override
	public Optional<Project> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Project update(Project p) {
		return repository.save(p);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
