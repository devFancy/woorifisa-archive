-- practice-ddl
CREATE DATABASE mart;

use mart;

select database();

-- 홈플러스 테이블 생성!
CREATE TABLE homeplus (
    homeplus_id SMALLINT UNSIGNED,
    employee_name VARCHAR(20),
    product_name VARCHAR(20),
    event_date DATE,
    street VARCHAR(20),
    CONSTRAINT pk_homplus PRIMARY KEY (homeplus_id)
);

desc homeplus;
desc seoul_milk;
SELECT 
    *
FROM
    seoul_milk;

-- 홈플러스 제휴 회사 테이블
CREATE TABLE seoul_milk (
	seoul_milk_id smallint unsigned,
    milk_name VARCHAR(20),
    FOREIGN KEY (seoul_milk_id)
        REFERENCES homeplus (homeplus_id)
        ON UPDATE CASCADE
);

-- 외래키 제약조건 추가
ALTER TABLE seoul_milk ADD CONSTRAINT fk_seoul_milk_homeplus_id FOREIGN KEY(homeplus_id)
REFERENCES homeplus (homeplus_id);

-- insert : 필드에 있는 data 넣기

-- 외래키 제약조건 비활성화
SET foreign_key_checks=0; -- 비활성화

ALTER TABLE homeplus MODIFY homeplus_id SMALLINT UNSIGNED AUTO_INCREMENT; -- 자동으로 값 ++

SET foreign_key_checks=1; -- 활성화

-- homeplus data insert
INSERT INTO homeplus
(employee_name, product_name, event_date, street)
VALUES ('이소민', '서울우유1', '2023-06-12', '서울');

select * from seoul_milk;


-- homeplus 제휴 회사 서울우유 data 생성
-- ALTER TABLE seoul_milk MODIFY homeplus_id SMALLINT UNSIGNED AUTO_INCREMENT; -- 자동으로 값 ++
-- Error Code: 1832. Cannot change column 'homeplus_id': used in a foreign key constraint 'fk_seoul_milk_homeplus_id'	0.0019 sec

drop table seoul_milk;

INSERT INTO seoul_milk
(seoul_milk_id, milk_name)
VALUES (1, '바나나우유');

select * from seoul_milk;
select * from homeplus;


