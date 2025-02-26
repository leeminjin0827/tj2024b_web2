drop database if exists day03board;
create database day03board;
use day03board;

create table board(
	bno int auto_increment ,
    title varchar(255) ,
    content varchar(255) ,
    constraint primary key( bno )
);

