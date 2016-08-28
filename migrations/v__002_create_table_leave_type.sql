create table leave_type (
    id int auto_increment,
    type varchar(20) not null,
    is_active tinyint(1) not null default 1,
    primary key (id)
);
