create table if not exists PERSON(
	id int not null primary key auto_increment,
	Full_Name varchar(50) not null,
	Date_Of_Birth date
);