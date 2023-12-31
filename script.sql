create database MetaphorceAssesment1;
use MetaphorceAssesment1;

create table Task(
	Id int primary key unique auto_increment not null,
    Description varchar(100) not null,
    State varchar(12) not null
);
-- enum('pending', 'in progress','completed')

insert into Task values
(default, 'This is the description for task 1', 'pending'),
(default, 'This is the description for task 2', 'in progress'),
(default, 'This is the description for task 3', 'pending'),
(default, 'This is the description for task 4', 'completed'),
(default, 'This is the description for task 5', 'pending');

create table users(
	Id int primary key unique auto_increment not null,
	name varchar(20)  not null,
    Password varchar(50) not null
);

insert into users values
(default,'root', 'root'),
(default,'user1', 'password123'),
(default,'user2', '123456789');
