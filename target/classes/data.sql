insert into cap_users(first_name, last_name, email, password) values('Jeck','Karkinsson','jeck@gmail.com', 'password');

insert into employees(hire_date) values('2019-11-26');

insert into absences(id_employee, type , description, start_date, end_date) values(1, 'Doctor','Diharrea','2019-12-13', '2019-12-16');

insert into projects(name , description, start_date, end_date) values('Petanca','Kicking balls','2019-12-11', '2019-12-18');

insert into skills(name , description) values('Ball tester','tests balls');

insert into employee_project_periods(id_employee, id_project, start_date, end_date, dedication) values(1, 1,'2019-12-11', '2019-12-18', 9);