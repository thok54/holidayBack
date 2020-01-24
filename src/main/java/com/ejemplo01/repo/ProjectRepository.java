package com.ejemplo01.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ejemplo01.entity.Project;

@RepositoryRestResource(path = "projectTree", collectionResourceRel = "projectTree")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Integer> {
	List<Project> findAll();

	Optional<Project> findById(Integer id);

	Project save(Project p);

	void deleteById(Integer id);
}