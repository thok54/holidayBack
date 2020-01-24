package com.ejemplo01.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "project")
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;
	@Column(name = "name")
	String name;
	@Column(name = "description")
	String description;
	@Column(name = "start_date")
	LocalDate startDate;
	@Column(name = "end_date")
	LocalDate endDate;

	@OneToMany(targetEntity = EmployeeProjectPeriod.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_project")
	@JsonIgnore
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	List<EmployeeProjectPeriod> employee_project_periods;

	@ManyToMany(mappedBy = "projectList")
	@JsonIgnore
	List<Employee> employeeList;

	@ManyToMany
	@JoinTable(name = "project_skills", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	List<Skill> projectSkills;
}
