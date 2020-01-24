package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo01.entity.Skill;
import com.ejemplo01.repo.SkillRepository;

@Service
public class SkillServiceImp implements SkillService {
	@Autowired
	private SkillRepository repository;

	@Override
	public List<Skill> listar() {
		return repository.findAll();
	}

	@Override
	public Optional<Skill> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Skill update(Skill skill) {
		return repository.save(skill);
	}


	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}
