DROP TABLE IF EXISTS employee_project;
DROP TABLE IF EXISTS employee_skills;
DROP TABLE IF EXISTS project_skills;
DROP TABLE IF EXISTS skills;
DROP TABLE IF EXISTS employee_project_periods;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS absences;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS cap_users;


CREATE TABLE cap_users
(
 id SERIAL PRIMARY KEY,
 first_name varchar(100) NOT NULL,
 last_name varchar(100) NOT NULL,
 email varchar(100) NOT NULL,
 password varchar(100) NOT NULL
);

CREATE TABLE employees
(
 id SERIAL PRIMARY KEY,
 hire_date DATE DEFAULT CURRENT_DATE
);


CREATE TABLE absences
(
 id SERIAL PRIMARY KEY,
 id_employee integer REFERENCES employees(id),
 type varchar(100) NOT NULL,
 description varchar(100) DEFAULT NULL,
 start_date DATE DEFAULT CURRENT_DATE,
 end_date DATE
);

CREATE TABLE projects
(
 id SERIAL PRIMARY KEY,
 name varchar(100),
 description varchar(100),
 start_date DATE DEFAULT CURRENT_DATE,
 end_date DATE DEFAULT CURRENT_DATE
);


CREATE TABLE employee_project_periods
(
 id SERIAL PRIMARY KEY,
 id_employee integer REFERENCES employees(id),
 id_project integer REFERENCES projects(id),
 start_date DATE DEFAULT CURRENT_DATE,
 end_date DATE,
 dedication integer
);

CREATE TABLE skills
(
 id SERIAL PRIMARY KEY,
 name varchar(100),
 description varchar(100)
);

CREATE TABLE employee_project
(
employee_id integer REFERENCES employees(id),
project_id integer REFERENCES projects(id)
);

CREATE TABLE employee_skills
(
employee_id integer REFERENCES employees(id),
skill_id integer REFERENCES skills(id)
);

CREATE TABLE project_skills
(
project_id integer REFERENCES projects(id),
skill_id integer REFERENCES skills(id)
);
