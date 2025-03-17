-- ---------------------- web ---------------------------------- --
INSERT INTO member (mid, mpwd, mname) VALUES
('user1', 'password123', '김철수'),
('user2', 'qwerty456', '이영희'),
('user3', 'abcde789', '박민준'),
('user4', 'helloWorld', '정다은'),
('user5', 'son1234', '손흥민');

-- ---------------------- day08 ---------------------------------- --
insert into productsample( name , price , comment ) values ( '코카콜라' , 1000 , '맛있는 코카콜라' );
insert into productsample( name , price , comment ) values ( '사이다' , 1700 , '제로 사이다입니다.' );
insert into productsample( name , price , comment ) values ( '환타' , 2000 , '새로나온 환타 맛 입니다.' );
-- ---------------------- ------ ---------------------------------- --

-- ---------------------- day05 ---------------------------------- --
-- 학생 테이블 샘플 데이터 삽입
-- INSERT INTO student (name, kor, math) VALUES ('김철수', 90, 85);
-- INSERT INTO student (name, kor, math) VALUES ('이영희', 78, 92);
-- INSERT INTO student (name, kor, math) VALUES ('박민수', 88, 76);
INSERT
    INTO student ( name , kor , math )
    VALUES ( '김철수' , 90 , 85 ) , ( '이영희' , 78 , 92 ) , ( '박민수' , 88 , 76 );


-- 성적 테이블 샘플 데이터 삽입 (트랜잭션 실습을 위해 일부 데이터만 추가)
INSERT INTO student_score (sno, subject, score) VALUES (1, '국어', 90);
INSERT INTO student_score (sno, subject, score) VALUES (1, '수학', 85);
INSERT INTO student_score (sno, subject, score) VALUES (2, '국어', 78);
INSERT INTO student_score (sno, subject, score) VALUES (2, '수학', 92);

-- ---------------------- ------ ---------------------------------- --

-- ---------------------- day09 ---------------------------------- --
insert into books( bname , buser , bmessage , bpassword )values
( "골든아워" , "이국종" , "외상외과는 힘들다" , "123456" ),
( "그리고아무도없었다" , "모름" , "그리고 아무도 없었다.." , "123456" ),
( "혼자공부하는자바" , "김자바" , "혼자공부해봐" , "123456" ),
( "인체의 신비" , "김인체" , "와 신비롭다" , "123456" ),
( "책을 많이읽는 방법" , "김책사" , "나도몰라" , "123456" );
insert into comment( cmessage , cpassword , bno )values
( "댓글1" , 1234 , 1 ),
( "댓글2" , 1234 , 1 ),
( "댓글3" , 1234 , 1 ),
( "댓글4" , 1234 , 4 ),
( "댓글5" , 1234 , 5 );
-- ---------------------- ------ ---------------------------------- --