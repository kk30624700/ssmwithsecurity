drop table if exists SYS_USER;
create table SYS_USER(
	id int primary key,
	username varchar(64) unique,
	password varchar(64));
	
drop table if exists SYS_ROLE;
create table SYS_ROLE(
	id int primary key,
	name varchar(64) unique
);

drop table if exists SYS_USER_ROLES;
create table SYS_USER_ROLES(
	user_id int not null, 
	role_id int not null
);

drop table if exists CITY;
create table CITY(
	id int primary key, 
	province_id int not null, 
	city_name varchar(64) unique
);

drop table if exists PROVINCE;
create table PROVINCE(
	id int primary key, 
	province_name varchar(64) unique
);


insert into SYS_USER(id,username,password) values(1, 'admin', 'admin');
insert into SYS_USER(id,username,password) values(2, 'guest', 'guest');

insert into SYS_ROLE(id, name) values(1, 'ROLE_ADMIN');
insert into SYS_ROLE(id, name) values(2, 'ROLE_USER');

insert into SYS_USER_ROLES(user_id, role_id) values(1, 1);
insert into SYS_USER_ROLES(user_id, role_id) values(2, 2);

insert into CITY(id, province_id, city_name) values(0, 0, '南京');

insert into PROVINCE(id, province_name) values(0, '江苏');