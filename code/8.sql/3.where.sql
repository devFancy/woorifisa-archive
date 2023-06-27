-- 3.where 명으로 파일 저장
-- SELECT , FROM , WHERE, JOIN, HAVING, GROUP BY, ORDER BY , ...

-- WHERE는 필터링이다.
-- customer 테이블에서 first_name이 KAREN인 회원의 모든 열 데이터 조회
SELECT * FROM customer WHERE first_name = 'KAREN';


-- Q. actor 테이블에서 first_name이 NICK인 회원의 first_name, last_name 데이터 조회
SELECT first_name AS fn, last_name FROM actor WHERE fn = "NICK";
-- Unknown column 'fn' in 'where clause'	0.0012 sec
-- select가 가장 마지막에 실행되기 때문에, where절에서의 별칭은 오류가 난다.


-- 컬럼의 별칭이 summary
-- 데이터 내용(record)은 '인어 공주'(title 열)의 줄거리, concatenation(문자열 집합)
SELECT concat(title, '의 줄거리 : ' , description) AS summary FROM film;


-- 무작위 행 데이터(Record) 반환(MySQL syntax), rand() 라는 내장함수
SELECT * FROM actor order by rand();


-- Q. customer 테이블에서 first_name이 "VIRGINIA" , last_name = 'BLUE'
SELECT 
    *
FROM
    customer
WHERE
    first_name = 'VIRGINIA'
        AND last_name = 'GREEN';
        

-- Q. film_category 테이블에서 category가 Animation이거나 Games인 모든 열 조회
select * from category;
select * from film_category;

SELECT 
    *
FROM
    film_category
WHERE
    category_id = '2' OR category_id = '10';
    

-- Q. customer 테이블에서 first_name = 'STEVEN' 이거나 last_name = 'YOUNG'이고,
-- create_date 가 2006-01-01 이후인 회원 조회
SELECT 
    *
FROM
    customer
WHERE
    (first_name = 'STEVEN'
        OR last_name = 'YOUNG')
        AND create_date >= '2006-01-01';
        
-- where절 뒤에 작성할 수 있는 건 조건식
-- = , !=, >, <, >=, LIKE, IN


-- Q. category 테이블에서 name이 Family가 아닌 모든 카테고리 조회
SELECT * FROM category WHERE name != 'Family';
SELECT * FROM category WHERE name <> 'Family';


-- 범위 조건(Range condition)
-- Q. rental 테이블에서 rental_date가 2005-05-25 이전에 빌려간 회원의 id와 대여 날짜를 조회
select * from rental;
SELECT 
    customer_id, rental_date
FROM
    rental
WHERE
    rental_date <= '2005-05-25';


-- Q. rental 테이블에서 rental_date가 2005-05-24부터 2005-05-25 사이의 rental_date 열 조회
select * from rental where rental_date between '2005-05-24' and '2005-05-25';


-- Q. 2005-05-24 오후 11시 ~ 2005-05-25 자정까지 1시간 동안의 rental_date 열 조회
select rental_date from rental where rental_date between '2005-05-24 23:00:00' and '2005-05-25 00:00:00';
SELECT 
    rental_date
FROM
    rental
WHERE
    rental_date BETWEEN '2005-05-24 23:00:00' AND '2005-05-25'; -- 위와 같음
    

-- Q. rental 테이블에서 rental_date가 2005-05-25 자정부터 2005-05-25 오전 1시까지 1시간 동안의 rental_date 열 조회
SELECT 
    rental_date
FROM
    rental
WHERE
    rental_date BETWEEN '2005-05-25' AND '2005-05-25 01:00:00'; -- 위와 같음
    

-- Q. payment table에서 amount가 10.0부터 10.99 사이의 모든 payment 조회
SELECT 
    *
FROM
    payment
WHERE
    amount BETWEEN 10.0 AND 10.99;



-- NULL , 정해지지 않은 값, 알려지지 않은 값을 나타낼 때 사용

-- Null의 특징 : 1. null과 null이 서로 같을 수 없다

-- Q. rental 테이블에서 customer_id가 155번인 대여기록 중 rental_id, customer_id, return_date 열만 조회
SELECT 
    rental_id, customer_id, return_date
FROM
    rental
WHERE
    customer_id = 155;


-- Q. rental 테이블에서 영화(film)를 반납하지 않은 대여기록 중 rental_id, customer_id, return_date 조회
-- return_date 가 null 인 요소 찾기
SELECT 
    rental_id, customer_id, return_date
FROM
    rental
WHERE
    return_date IS NULL; 
    -- 실제 return_date 컬럼의 값이 NULL로 할당 된 행을 우항의 NULL과 비교를 하게 되는데, 
    -- NULL = NULL 에 대한 비교가 성립이 안되기 때문에 비어있는 결과(Empty set)가 조회됨
    -- 반납하지 않은 고객의 데이터가 없다는 의미가 아님
    

-- Q. rental 테이블에서 영화를 반납한 대여기록 중 rental_id, customer_id, return_date를 상위 50개만 조회
SELECT 
    rental_id, customer_id, return_date
FROM
    rental
WHERE
    return_date IS NOT NULL
LIMIT 50;


-- Q. rental 테이블에서 2005년 5월에서 8월 사이에 반납되지 않은 대여기록 중 rental_id, customer_id, return_date를 조회
SELECT 
    rental_id, customer_id, return_date
FROM
    rental
WHERE
    return_date NOT BETWEEN '2005-05-01' AND '2005-09-01';
   
   
-- Q. NULL까지 포함하기 위해서는 별도의 조건
SELECT 
    rental_id, customer_id, return_date
FROM
    rental
WHERE
    return_date IS NULL
        OR return_date NOT BETWEEN '2005-05-01' AND '2005-09-01';


        
-- 와일드 카드(LIKE) - 쿼리 성능상 좋지는 않다 ~ 권장되지는 않음
select * from customer where first_name = 'KAREN';

-- Q. customer 테이블에서 last_name의 두 번째 문자에는 A가, 네 번째 문자에는 T가 포함되고, 
-- 마지막 문자는 S로 끝나는 고객의 last_name과 first_name을 조회
SELECT 
    last_name, first_name
FROM
    customer
WHERE
    last_name LIKE '_A_T%S'; 
-- 아무글자나 와도 되는 경우 : '_' 사용
-- 두개이상의 문자들이 와도 되는 경우 : '%' 사용


-- Q. customer 테이블에서 last_name이 Q로 시작하거나 Y로 시작하는 고객의 last_name, first_name 조회
SELECT 
    last_name, first_name
FROM
    customer
WHERE
    last_name LIKE 'Q%'
        OR last_name LIKE 'Y%'; -- 한번 더 반복하면 됨

