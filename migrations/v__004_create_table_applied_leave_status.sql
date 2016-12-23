create table applied_leave_status (
    id int auto_increment,
    status varchar(15) not null,
    is_active tinyint(1) not null default 1,
    primary key (id)
);
