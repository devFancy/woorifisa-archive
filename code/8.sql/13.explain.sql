-- 13.explain

-- actor 테이블의 CREATE query 조회
SHOW CREATE TABLE actor;

-- actor 테이블 통계 정보 조회
use sakila;

-- SHOW TABLE STATUS LIKE 'actor\g';

-- film_actor 테이블에서 film_id가 1번인 모든 열 데이터를 조회하는 쿼리의 실행 계획 조회
EXPLAIN SELECT * FROM film_actor WHERE film_id = 1;

-- EXPLAIN 결과셋 컬럼 설명
EXPLAIN SELECT customer_id, first_name, last_name 
FROM customer 
WHERE customer_id = (SELECT MAX(customer_id) FROM customer);

-- > partition : table 분할
-- > type : 결과값이 단일 행 = const ... 등 교안에 EXPLAIN 키워드 부분에 나와있음.

-- 범위 조건으로 조회할 경우 type은 range
EXPLAIN SELECT * FROM rental WHERE rental_date BETWEEN '2005-05-24' AND '2005-05-25';

-- 인덱스가 없는 컬럼으로 조회 시 type은 ALL
explain select * from actor where first_name = 'PENELOPE';
select * from actor where first_name = 'PENELOPE';

EXPLAIN SELECT now();