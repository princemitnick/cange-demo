create database cange;

use cange;


CREATE TABLE persons (
    person_id int AUTO_INCREMENT,
    last_name varchar(255) not null,
    first_name varchar(255),
    age int,
    primary key(person_id)
);

