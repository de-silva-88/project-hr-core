insert into gender(gender_name, created_by) values("Male", 1);
insert into gender(gender_name, created_by) values("Female", 1);

insert into religion(religion_name) values("Islam");
insert into religion(religion_name) values("Christianity");
insert into religion(religion_name) values("Hinduism");

insert into race(race_name) values("Sinhalese");
insert into race(race_name) values("Tamil");
insert into race(race_name) values("Muslim");

insert into nationality(nationality_name) values("Sri Lankan");
insert into civil_status(civil_status_name, created_by) values("Single", 1);
insert into civil_status(civil_status_name, created_by) values("Married", 1);

insert into blood_group(blood_group_name) values("A+");
insert into blood_group(blood_group_name) values("A-");

insert into blood_group(blood_group_name) values("B+");

insert into blood_group(blood_group_name) values("B-");

insert into blood_group(blood_group_name) values("AB+");

insert into blood_group(blood_group_name) values("AB-");

insert into blood_group(blood_group_name) values("O+");

insert into blood_group(blood_group_name) values("O-");

insert into tshirt_size(size, created_by) values("S",1);

insert into tshirt_size(size, created_by) values("M",1);

insert into tshirt_size(size, created_by) values("L",1);

insert into tshirt_size(size, created_by) values("XL",1);

insert into tshirt_size(size, created_by) values("XXL",1);

insert into title(title_name, created_by) values("Mr.",1);
insert into title(title_name, created_by) values("Mrs.",1);

insert into title(title_name, created_by) values("Ms.",1);
insert into title(title_name, created_by) values("Rev.",1);

CREATE TABLE emp_work(
id INT AUTO_INCREMENT PRIMARY KEY,
emp_number INT NOT NULL,
company_id INT NOT NULL,
department_id INT NOT NULL,
section_id INT NOT NULL,
location_id INT NOT NULL,
emp_type_id INT NOT NULL,
working_type_id INT NOT NULL,
appointmentDate DATE NOT NULL,
probation TINYINT(1) NOT NULL DEFAULT 0,
probation_duration INT DEFAULT 0,
probation_extended TINYINT(1) NOT NULL DEFAULT 0,
pro_extnd_duration INT DEFAULT 0,
office_email VARCHAR(60) NULL,
distance_from_residence DOUBLE NOT NULL DEFAULT 0.0,
vehicle_issued TINYINT(1) NOT NULL DEFAULT 1,
vehicle_type VARCHAR(50) NULL,
vehicle_number VARCHAR(20) NULL,
vehicle_pass_issued TINYINT(1) NOT NULL DEFAULT 0,
vehicle_pass_number VARCHAR(15) NULL,
overtime TINYINT(1) NOT NULL DEFAULT 0,
overtime_rate VARCHAR(255) NULL,description VARCHAR(255) NULL
);
alter table employee change distance_form_residence tshirt_size_id int not null;
CREATE TABLE tshirt_size(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
size VARCHAR(20) NOT NULL, 
is_active TINYINT(1) NOT NULL DEFAULT 1, 
created_by INT NOT NULL, 
created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
updated_by INT NULL, 
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);

insert into collar_size(size, created_by) values("15''",1);

insert into collar_size(size, created_by) values("15'' 1/2'",1);

insert into collar_size(size, created_by) values("16''",1);

insert into collar_size(size, created_by) values("16'' 1/2'",1);

insert into company(company_name) values("Brandix Pvt Ltd.");
insert into department (department_name) values ( "Test Department");
insert into department (department_name) values ( "Test Department 1");
insert into department (department_name) values ( "Test Department 2");

insert into section (section_name) values ( "Test section 1");

insert into section (section_name) values ( "Test section 2");

insert into section (section_name) values ( "Test section 3");

alter table employee change blood_group blood_group_id int not null;

insert into employee(card_number,gender_id,title_id,initials,first_name,last_name,full_name,nic_name,
dob,nic,civil_status_id,religion_id,race_id,nationality_id,blood_group_id,personal_email,tshirt_size_id,
collar_size_id, emp_image,created_by)
values("103A2",1,1,"A. C.","Dasun","Tharaka","Dasun tharaka udayanga","dasu","1988-03-21","881230500v",1,
1,1,1,1,"dasun@gmail.com",1,1,"dasu.jpg",1);