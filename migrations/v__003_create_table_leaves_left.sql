create table leaves_left (
    id int auto_increment,
    emp_id int not null,
    leave_type int not null,
    leaves_left decimal(4,1)  not null,
    is_active tinyint not null default 0,
    primary key (id),
    foreign key (emp_id) references employee (id)
);
