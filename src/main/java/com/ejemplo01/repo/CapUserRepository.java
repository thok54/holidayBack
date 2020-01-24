package com.ejemplo01.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ejemplo01.entity.CapUser;

@RepositoryRestResource(path = "capUserTree", collectionResourceRel = "capUserTree")
public interface CapUserRepository extends PagingAndSortingRepository<CapUser, Integer> {
	List<CapUser> findAll();

	Optional<CapUser> findById(Integer id);

	CapUser save(CapUser p);

	void deleteById(Integer id);
	
	CapUser findByEmail(String email);
}