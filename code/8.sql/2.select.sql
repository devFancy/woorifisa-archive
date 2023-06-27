-- language 테이블의 모든 열에 해당하는 전체 데이터 조회
SELECT * FROM language;

-- language 테이블에서 language_id, name, last_update 열(column)에
-- 해당하는 모든 데이터 조회
SELECT language_id, name, last_update FROM language;

-- language 테이블에서 language_id 열의 이름을 '언어ID'
-- name 열의 이름을 '언어명'
-- last_update 열의 이름을 '마지막 업데이트'로
-- 별칭을 지정하여 조회 (AS 는 생략 가능)
SELECT language_id AS '언어ID', name AS '언어명', last_update AS '마지막 업데이트' FROM language;

-- film_category 테이블에서 category가 Sci-Fi 인 film만 조회
SHOW tables; -- 전체 테이블 정보 조회, category 테이블 확인
SELECT * FROM category; -- category 테이블 조회, Sci-fi 번호 확인(14번)
SELECT * FROM film_category WHERE category_id = 14;
-- from 절에서 테이블을 먼저 찾고 -> where절에 해당하는 부분만 가져와서 -> select 조건에 따라 보여줌