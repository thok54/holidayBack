package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo01.entity.Skill;

public interface SkillService {
	List<Skill> listar();

	Optional<Skill> findById(Integer id);

	Skill update(Skill skill);

	void deleteById(Integer id);

}
