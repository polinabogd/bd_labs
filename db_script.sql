drop database if exists bogdanovska_7_2;
create database bogdanovska_7_2;
use bogdanovska_7_2;

drop table if exists password;
drop table if exists  book_links;
drop table if exists  catalog_tree;
drop table if exists  book;
drop table if exists  user;
drop table if exists user_has_book;

create table book_links(
	id int not null,
	book_address varchar(100) not null unique,
    book_id int not null unique
);

create table catalog_tree(
	id int not null unique,
	category varchar(45) not null unique,
    catalog_tree_id int not null 
);

create table book(
	id int not null unique,
	name varchar(80) not null,
	authors varchar(80) not null,
	UDC varchar(100) not null unique,
	rating int not null,
	catalog_tree_id int not null unique,
    user_has_book_id int not null 
);

create table user(
	login varchar(45) not null primary key,
	surname varchar(45) not null,
	name varchar(45) not null,
	fathername varchar(45) not null,
	birthdate date not null,
	birthplace varchar(45) not null,
	domicile varchar(45) not null,
	comment varchar(80) not null,
	rating int not null unique,
	user_has_book_id int not null 
);

create table user_has_book(
	id int primary key,
	user_login varchar(45) not null,
	book_id int not null
);

create table password(
	id int not null primary key,
	password varchar(45) not null,
	user_login varchar(45) not null unique
);