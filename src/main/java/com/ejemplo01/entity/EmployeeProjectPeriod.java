package com.ejemplo01.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "employee_project_period")
@Table(name = "employee_project_periods")
public class EmployeeProjectPeriod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;
	@Column(name = "id_employee")
	int idEmployee;
	@Column(name = "id_project")
	int idProject;
	@Column(name = "start_date")
	LocalDate startDate;
	@Column(name = "end_date")
	LocalDate endDate;
	@Column(name = "dedication")
	int dedication;

	@ManyToOne
	@JoinColumn(name = "id_employee", insertable = false, updatable = false)
	Employee employee;

	@ManyToOne
	@JoinColumn(name = "id_project", insertable = false, updatable = false)
	Project project;
}