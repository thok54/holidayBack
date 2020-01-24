package com.ejemplo01.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ejemplo01.entity.Skill;

@RepositoryRestResource(path = "skillTree", collectionResourceRel = "skillTree")
public interface SkillRepository extends PagingAndSortingRepository<Skill, Integer> {
	List<Skill> findAll();

	Optional<Skill> findById(Integer id);

	Skill save(Skill p);

	void deleteById(Integer id);
}