package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo01.entity.CapUser;
import com.ejemplo01.repo.CapUserRepository;

@Service
public class CapUserServiceImp implements CapUserService {
	@Autowired
	private CapUserRepository repository;

	@Override
	public List<CapUser> listar() {
		return repository.findAll();
	}

	@Override
	public Optional<CapUser> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public CapUser update(CapUser p) {
		return repository.save(p);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	@Override
	public CapUser findByEmail(String email) {
		return repository.findByEmail(email);
	}

}
