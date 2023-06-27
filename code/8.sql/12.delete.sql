-- 12.delete.sql
-- DELETE: 테이블 내 데이터만 제거, DROP: 테이블 자체를 통째로 제거

-- DML(Data Manipulation) - SELECT, INSERT, UPDATE, DELETE
-- DDL(Data Definition) - CREATE, DROP, ALTER

-- 작성문법: DELETE FROM 테이블명
DELETE FROM person;
-- Cannot delete or update a parent row: 
-- a foreign key constraint fails (`testdb`.`favorite_food`, CONSTRAINT `fk_favorite_food_person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`))

SELECT * FROM favorite_food;

-- 외래키 제약조건 제거
ALTER TABLE favorite_food DROP FOREIGN KEY fk_favorite_food_person_id;

-- 부모 테이블의 데이터 삭제 시 자식 테이블의 데이터도 같이 제거되도록 CASCADE 속성
ALTER TABLE favorite_food
ADD CONSTRAINT FOREIGN KEY (person_id)
REFERENCES person(person_id)
ON DELETE CASCADE; -- 부모 테이블 데이터 제거 시 자식 테이블의 엮인 데이터도 같이 제거

-- 제약조건 확인
SELECT * FROM information_schema.table_constraints WHERE table_name = 'favorite_food';

DELETE FROM person; -- 별도의 WHERE 키워드를 작성하지 않으면 전체 행이 제거됨