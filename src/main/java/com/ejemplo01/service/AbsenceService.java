package com.ejemplo01.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo01.entity.Absence;

public interface AbsenceService {
	List<Absence> listar();

	Optional<Absence> findById(Integer id);

	Absence update(Absence p);

	void deleteById(Integer id);

}
