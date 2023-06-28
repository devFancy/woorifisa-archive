-- 8.ext-exercise1

-- 1. actor 테이블 내 모든 컬럼이 포함된 전체 데이터(행) 조회
select * from actor;


-- 2. actor 테이블에서 last_name 컬럼만 포함된 전체 데이터 조회
select last_name from actor;


-- 3. film 테이블에서 영화 제목, 영화 설명, 대여 기간(rental_duration),
-- 대여 비용(rental_rate), 총 렌탈 비용(직접 생성할 새로운 컬럼)에 해당하는 데이터를 상위 10개만 조회
/*
컬럼 설명
-   `rental_duration`: 대여 기간(day 기준), 
→ The length of the rental period, in days
-   `rental_rate`: `rental_duration` 컬럼에 저장된 기간 동안 film을 대여하는데 필요한 비용
The cost to rent the film for the period specified in the `rental_duration` column
*/
select * from film;
SELECT
    title,
    description,
    rental_duration,
    rental_rate,
    SUM(rental_rate)
FROM
    film
GROUP BY film_id
LIMIT 10;


-- 4. actor 테이블에서 서로 다른(겹치지 않는) last_name열에 해당하는 모든 데이터 조회
select * from actor;
select last_name from actor group by last_name;


-- 5. address 테이블에서 서로 다른 postal_code열에 해당하는 모든 데이터 조회
SELECT DISTINCT
    postal_code
FROM
    address;


-- 6. film 테이블에서 영화 제목, 줄거리, rating(영화 등급), length(영화 러닝타임, minutes 기준) 열에 해당하는 모든 데이터를 조회하되, 러닝타임이 3시간 이상인 데이터만 필터링하여 조회
select * from film;
SELECT 
    title, description, rating, length
FROM
    film
WHERE
    length >= 180;


-- 7. payment 테이블에서 payment_id, 금액, 지불날짜 열에 해당하는 모든 데이터를 조회하되, 2005년 8월 23일 자정 이후에 지불된 데이터만 필터링하여 조회
select * from payment;
SELECT 
    payment_id, amount, payment_date
FROM
    payment
WHERE
    payment_date > '2005-08-23 00:00:00';


-- 8. payment 테이블에서 payment_id, 금액, 지불날짜 열에 해당하는 모든 데이터를 조회하되, 지불날짜가 2005년 8월 23일만 해당하는 모든 데이터 조회
select * from payment;
SELECT 
    payment_id, amount, payment_date
FROM
    payment
WHERE
    payment_date BETWEEN '2005-08-23 00:00:00' AND '2005-08-24 00:00:00';


-- 9. customer 테이블에서 모든 열에 해당하는 데이터를 조회하되, last_name이 s로 시작하고, first_name이 n으로 끝나는 데이터만 필터링하여 조회
SELECT 
    *
FROM
    customer
WHERE
    last_name LIKE 's%'
        AND first_name LIKE '%n';


-- 10. customer 테이블에서 모든 열에 해당하는 데이터를 조회하되, 휴면 사용자(active 컬럼 참고) 이면서, last_name이 m으로 시작하는 데이터만 필터링하여 조회
SELECT 
    *
FROM
    customer
WHERE
    active = '0' AND last_name LIKE 'm%';


-- 11. category 테이블에서 모든 열에 해당하는 데이터를 조회하되, category_id가 4보다 크고, name 열에 해당하는 데이터가 c로 시작하거나, s로 시작하거나, t로 시작하는 데이터로 필터링하여 조회
SELECT 
    *
FROM
    category
WHERE
    category_id > 4 AND name LIKE 'c%'
        OR name LIKE 's%'
        OR name LIKE 't%';


-- 12. address 테이블에서 phone, 구역(district) 컬럼을 조회하되, 구역이 California, England, Taipei,  West Java에 해당하는 구역만 필터링하고, district 컬럼을 기준으로 오름차순 정렬하여 조회
select * from address;
SELECT 
    phone, district
FROM
    address
WHERE
    district = 'California'
        OR district = 'England'
        OR district = 'Taipei'
        OR district = 'West Java'
ORDER BY district ASC;



-- 13. payment 테이블에서 payment_id, 금액, 지불날짜 열에 해당하는 데이터를 조회하되, 지불날짜가 2005년 8월 23일, 24일, 25일에 해당하는 데이터만 조회(`IN, Date()` 활용)
-- ???
select * from payment;
SELECT 
    payment_id, amount, payment_date
FROM
    payment
WHERE
    payment_date IN (DATE('2005-08-23 00:00:00') , DATE('2005-08-24 00:00:00'),
        DATE('2005-08-25 00:00:00'));



-- 14. film 테이블에서 모든 열에 해당하는 데이터를 조회하되, rate(등급)가 G, PG-13, NC-17에 해당되는 데이터만 조회
select * from film;
SELECT 
    *
FROM
    film
WHERE
    rating IN ('G' , 'PG-13', 'NC-17');


-- 15. payment 테이블에서 모든 열에 해당하는 데이터를 조회하되, payment_date가 2005년 8월 23일에만 해당하는 데이터 조회
select *
from payment
where payment_date between '2005-08-23' and '2005-08-24';


-- 16. film 테이블에서 제목, 줄거리, 출시연도, 총 대여비용(rental_duration, rental_rate 활용)열에 해당하는 데이터를 조회하되, 러닝타임이 100 ~ 120분 사이에 해당하는 데이터만 조회
select * from film;
SELECT 
    title,
    description,
    release_year,
    (rental_duration * rental_rate) AS '총 대여비용'
FROM
    film
WHERE
    length BETWEEN 100 AND 120;


-- 17. film 테이블에서 제목, 줄거리, 출시연도에 해당하는 데이터를 조회하되, 줄거리가 'A Thoughtful'로 시작하는 데이터를 영화 제목을 기준으로 오름차순 정렬하여 조회
select * from film;
SELECT 
    title, description, release_year
FROM
    film
WHERE
    description LIKE 'A Thoughtful%'
ORDER BY title ASC;


-- 18. film 테이블에서 제목, 줄거리, 대여기간에 해당하는 데이터를 조회하되, 줄거리가 '~Boat'로 끝나는 데이터를 영화 제목을 기준으로 내림차순 정렬하여 조회
SELECT 
    title, description, release_year
FROM
    film
WHERE
    description LIKE '%Boat'
ORDER BY title DESC;


-- 19. film 테이블에서 제목, 러닝타임, 줄거리, 대여 비용에 해당하는 모든 데이터를 조회하되, 줄거리에 'database'라는 텍스트가 포함되어 있고, 러닝타임이 180분 보다 긴 데이터를 제목을 기준으로 오름차순 정렬하여 조회
select * from film;
SELECT 
    title, length, description, rental_rate
FROM
    film
WHERE
    description LIKE '%database%'
        AND length > 180
ORDER BY title ASC;

