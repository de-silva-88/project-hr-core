alter table company change company company_name varchar(50) NOT NULL;
alter table department change department department_name varchar(50) NOT NULL;
alter table department modify is_active tinyint(1) not null default 1;

alter table company modify is_active tinyint(1) not null default 1;

alter table section modify is_active tinyint(1) not null default 1;

alter table section change section section_name varchar(50) NOT NULL;

alter table section drop column company_id;
alter table section drop column department_id;

alter table department drop column company_id;
CREATE TABLE gender (
gender_id INT NOT NULL AUTO_INCREMENT, 
gender_name VARCHAR(20) NOT NULL, 
is_active TINYINT(1) NOT NULL DEFAULT 1,created_by INT NOT NULL, created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
 updated_by INT NULL, updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
PRIMARY KEY(gender_id)
);
CREATE TABLE title (
title_id INT NOT NULL AUTO_INCREMENT, 
title_name VARCHAR(20) NOT NULL, 
is_active TINYINT(1) NOT NULL DEFAULT 1,created_by INT NOT NULL, created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
 updated_by INT NULL, updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
PRIMARY KEY(title_id)
);
CREATE TABLE civil_status (
civil_status_id INT NOT NULL AUTO_INCREMENT, 
civil_status_name VARCHAR(20) NOT NULL, 
is_active TINYINT(1) NOT NULL DEFAULT 1,
created_by INT NOT NULL, 
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

 updated_by INT NULL, 
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
PRIMARY KEY(civil_status_id)
);

alter table blood_group modify column is_active tinyint(1) not null default 1;
alter table blood_group change blood_group blood_group_name char(5) not null;

alter table location modify is_active tinyint(1) not null default 1;

alter table location change location  location_name varchar(30) not null;

alter table nationality modify is_active tinyint(1) not null default 1;

alter table nationality change nationality nationality_name varchar(30) not null;

alter table race modify is_active tinyint(1) not null default 1;

alter table race change race race_name varchar(30) not null;

alter table religion modify is_active tinyint(1) not null default 1;

alter table religion change religion religion_name varchar(30) not null;

alter table working_type modify is_active tinyint(1) not null default 1;

alter table working_type change working_type working_type_name varchar(30) not null;

alter table address_type modify is_active tinyint(1) not null default 1;
alter table contact_type modify is_active tinyint(1) not null default 1;

alter table edu_type modify is_active tinyint(1) not null default 1;
alter table emp_type modify is_active tinyint(1) not null default 1;

alter table emp_type change emp_type emp_type_name varchar(20) not null;

alter table designation modify is_active tinyint(1) not null default 1;
alter table address modify is_active tinyint(1) not null default 1;

CREATE TABLE bank(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
bank_name VARCHAR(50) NOT NULL, 
is_active TINYINT(1) NOT NULL DEFAULT 1, 
created_by INT NOT NULL, 
created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
updated_by INT NULL, 
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);
drop table bank_details;

CREATE TABLE bank_details(
id INT NOT NULL AUTO_INCREMENT, 
emp_number INT NOT NULL, 
bank_id INT NOT NULL, 
branch VARCHAR(20) NULL, 
bank_code CHAR(10) NULL,
branch_code CHAR(10) NULL, 
account_number VARCHAR(255) NULL,
is_active TINYINT(1) NOT NULL DEFAULT 1, 
created_by INT NOT NULL, 
created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
updated_by INT NULL, 
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, PRIMARY KEY(id));

CREATE TABLE relation_type(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
relation_type_name VARCHAR(50) NOT NULL, 
is_active TINYINT(1) NOT NULL DEFAULT 1, 
created_by INT NOT NULL, 
created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
updated_by INT NULL, 
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);
CREATE TABLE emergency_contact(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
emp_number INT NOT NULL, 
relation_type_id INT NOT NULL,
contact_person_name VARCHAR(50) NOT NULL, 
personal_number VARCHAR(15) NULL,
Company_name VARCHAR(50) NULL, 
designation VARCHAR(50) NULL, 
company_address VarCHAR(60) NULL, 
office_number VARCHAR(15) NULL,
is_active TINYINT(1) NOT NULL DEFAULT 1, 
created_by INT NOT NULL, 
created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
updated_by INT NULL, 
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);

alter table designation change designation designation_name varchar(50) not null;
CREATE TABLE documnet_type(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
document_type_name VARCHAR(50) NOT NULL, 
is_active TINYINT(1) NOT NULL DEFAULT 1, 
created_by INT NOT NULL, 
created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
updated_by INT NULL, 
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);

CREATE TABLE emp_document(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
emp_number INT NOT NULL,
document_type_id INT NOT NULL,
document_name VARCHAR(100) NULL,
description VARCHAR(200) NULL,
is_active TINYINT(1) NOT NULL DEFAULT 1, 
created_by INT NOT NULL, 
created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
updated_by INT NULL, 
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);

alter table education modify is_active tinyint(1) not null default 1;

drop table education;
CREATE TABLE education(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
emp_number INT NOT NULL, 
edu_type_id INT NOT NULL,
venue VARCHAR(50) NULL, 
edu_year CHAR(4) null, 
edu_comment VARCHAR(100) NULL,
is_active TINYINT(1) NOT NULL DEFAULT 1, 
created_by INT NOT NULL, 
created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
updated_by INT NULL, 
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);


CREATE TABLE collar_size(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
size VARCHAR(20) NOT NULL, 
is_active TINYINT(1) NOT NULL DEFAULT 1, 
created_by INT NOT NULL, 
created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
updated_by INT NULL, 
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);
alter table employee change collar_size collar_size_id int not null; 
alter table employee change national_id nationality_id int not null; 