-- 10.ddl.sql

-- Data definition language
-- 데이터 정의어, CREATE , DROP, ALTER

use sakila;

desc film_actor;

-- 테이블 생성(create 명령어 사용)
-- DB 생성할 때는 CREATE DATABASE ~
-- create table mouse (필드, 타입, 제약 조건 기술하는 부분)

-- 연습용 DB 생성
CREATE database testdb;

SELECT DATABASE();

use testdb;

CREATE TABLE person ( -- CREATE TABLE 테이블명
	person_id SMALLINT UNSIGNED, -- 필드 데이터타입,(comma로 구분)
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	eye_color ENUM('BR', 'BL', 'GR'),
	birth_date DATE,
	street VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(20)
);

show tables;
desc person;



-- 기본키를 추가하지 않아서 테이블 제거(DROP TABLE 제거할 테이블명)
drop table person;

CREATE TABLE person ( -- CREATE TABLE 테이블명
	person_id SMALLINT UNSIGNED, -- 필드 데이터타입,(comma로 구분)
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	eye_color ENUM('BR', 'BL', 'GR'),
	birth_date DATE,
	street VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(20),
	CONSTRAINT pk_person PRIMARY KEY (person_id) -- 기본키로 사용하곘다는 제약조건 명시
    -- 제약 조건 pk_person 은 기본키로 person_id 를 지정하겠다는 의미
    -- CONSTRAINT 제약조건이름 조건 키워드(조건을 적용할 컬럼명)
	-- CONSTRAINT 제약조건이름 PRIMARY KEY (필드이름)
);
-- 확인해보기
show tables;
desc person;
-- person_id key값이 PRI가 된 것을 확인할 수 있다.


-- Person 이 좋아하는 음식을 담고 있는 테이블 생성
CREATE TABLE favorite_food (
	person_id smallint,
    food varchar(20), -- food : 음식이름
    
    -- 복합키
    CONSTRAINT pk_favorite_food PRIMARY KEY (person_id, food)
);

desc favorite_food;

-- 테이블 생성 쿼리 조회
show create table favorite_food;

-- favorite_food 테이블에서 person_id를 외래키(foreign key)로 추가하는 것을 잊었을 때
alter table favorite_food add constraint fk_favorite_food_person_id
foreign key (person_id) -- favorite_food 테이블에 있는 person_id 컬럼을 외래키로
references person (person_id); -- 그 외래키는 person 테이블의 person_id를 참조한다.

-- SELECT * FROM information_schema.table_constraints;

-- 테이블에 데이터 삽입(INSERT)
-- INSERT INTO 테이블명 (컬럼명, ...) VALUES (실제 값, ...);
DESC person;
insert into person (person_id, first_name, last_name) values (1, 'Kim', 'Seungyeon');
insert into person (person_id, first_name, last_name) values (1, 'Im', 'Yeji');
-- Error Code: 1062. Duplicate entry '1' for key 'person.PRIMARY' : primary key가 중복되어 오류 발생!


-- person_id 컬럼은 기본키이기 때문에, 1씩 증가하도록해서 고유성을 보장하도록 설정 변경
alter table person MODIFY person_id smallint auto_increment;
-- -> person 테이블의 person_id 컬럼 필드를 변경(데이터 insert 시 자동 증가하도록 설정 적용)

-- 외래키 제약조건 비활성화
set foreign_key_checks = 0; -- 비활성화
alter table person MODIFY person_id smallint auto_increment;
set foreign_key_checks = 1;

insert into person (first_name, last_name)
values ('wow', 'wow'); -- 자동으로 person_id 컬럼 값이 증가하여 적용됨 (auto_increment)

select *
from person;

insert into person (first_name, last_name, eye_color, birth_date, street)
values ('WOW', 'LEE', 'BR', '1999-05-02', 'MILE TASTE STREET');
-- Error Code: 1136. Column count doesn't match value count at row 1
-- 컬럼에 match 되는 value 값이 없어서 발생한 오류

insert into person (first_name, last_name, eye_color, birth_date, street)
values ('WOW', 'LEE', 'RD', '1999-05-02', 'MILE TASTE STREET');
-- Error Code: 1265. Data truncated for column 'eye_color' at row 1
-- RD는 ENUM컬럼에서 허용되지 않은 값이기 때문에 INSERT 불가



-- 실습하기 ~
INSERT INTO favorite_food (person_id, food) VALUES (1, 'pizza');

desc favorite_food;
select * from favorite_food;

INSERT INTO favorite_food (person_id, food) VALUES (2, 'salad');
INSERT INTO favorite_food (person_id, food) VALUES (3, 'ace');

INSERT INTO favorite_food (person_id, food) VALUES (2, 'salad');

select * from person;
select * from favorite_food;
