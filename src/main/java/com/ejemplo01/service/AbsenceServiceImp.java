package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo01.entity.Absence;
import com.ejemplo01.repo.AbsenceRepository;

@Service
public class AbsenceServiceImp implements AbsenceService {
	@Autowired
	private AbsenceRepository repository;

	@Override
	public List<Absence> listar() {
		return repository.findAll();
	}

	@Override
	public Optional<Absence> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Absence update(Absence p) {
		return repository.save(p);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
