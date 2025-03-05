drop database if exists service;
create database service;
use service;

-- 고객센터 테이블
create table senter(
	sno int auto_increment ,
    stitle varchar(30) not null ,
    scontent longtext not null ,
    spassword varchar(4) not null ,
    suser varchar(10) not null ,
    constraint primary key(sno)
);

-- 고객센터샘플
insert into senter ( stitle , scontent , spassword , suser ) values
( "불편합니다" ,  "불편함" , 1234 , "김불편" ),
( "불편합니다" ,  "불편함" , 1234 , "김불편" ),
( "불편합니다" ,  "불편함" , 1234 , "김불편" ),
( "불편합니다" ,  "불편함" , 1234 , "김불편" ),
( "불편합니다" ,  "불편함" , 1234 , "김불편" );

select sno , stitle , scontent , suser from senter;
