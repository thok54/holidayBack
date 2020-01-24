package com.ejemplo01.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ejemplo01.entity.Absence;

@RepositoryRestResource(path = "absenceTree", collectionResourceRel = "absenceTree")
public interface AbsenceRepository extends PagingAndSortingRepository<Absence, Integer> {
	List<Absence> findAll();

	Optional<Absence> findById(Integer id);

	Absence save(Absence p);

	void deleteById(Integer id);
}