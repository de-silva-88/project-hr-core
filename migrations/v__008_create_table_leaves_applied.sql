create table leaves_applied (
    id int auto_increment,
    emp_id int not null,
    leave_type int not null,
    number_of_leaves int not null,
    status int not null,
    applied_on timestamp not null default current_timestamp,
    reviewed_on date null default null,
    reviewed_by int not null,
    is_active tinyint not null default 1,
    primary key (id),
    foreign key (emp_id) references employee (id),
    foreign key (leave_type) references leave_type (id),
    foreign key (status) references applied_leave_status (id),
    foreign key (reviewed_by) references employee (id)
);
