-- 11.update.sql

-- * Person 테이블 전체 조회
SELECT * FROM person;

-- UPDATE 키워드 기본 Syntax 
-- UPDATE 테이블명
-- SET 수정할 필드명 = '수정할 값',
-- [수정할 필드명 = '수정할 값'], ...
-- [WHERE Exp];

-- * person
UPDATE person 
SET 
    street = 'GREEN TEA STREET',
    state = 'MA',
    country = 'USA',
    postal_code = '15232';
-- Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.00058 sec

SET sql_safe_updates = 1;

UPDATE person 
SET 
    street = 'SPIDER STREET',
    state = 'NA',
    country = 'USA',
    postal_code = '14231'
WHERE
    person_id = 2;