package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo01.entity.CapUser;

public interface CapUserService {

	List<CapUser> listar();

	Optional<CapUser> findById(Integer id);

	CapUser update(CapUser capUser);

	void deleteById(Integer id);
	
	CapUser findByEmail(String email);
}
