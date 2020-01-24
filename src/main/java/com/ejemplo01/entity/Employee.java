package com.ejemplo01.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "employee")
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;
	@Column(name = "hire_date")
	LocalDate hireDate;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@MapsId("id")
	@JoinColumn(name = "id", nullable = false)
	CapUser cap_user;

	@OneToMany(targetEntity = EmployeeProjectPeriod.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_employee")
	@JsonIgnore
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	List<EmployeeProjectPeriod> employee_project_periods;

	@OneToMany(targetEntity = Absence.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_employee")
	@JsonIgnore
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	List<Absence> absences;

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	List<Project> projectList;

	@ManyToMany
	@JoinTable(name = "employee_skills", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	List<Skill> employeeSkills;
}
