-- 6.groupby

-- rental 테이블을 조회해서
-- 가장 대여를 많이 한 고객에게 사은품을 주어야하는데, 그러한 고객을 찾기 위한 방법
use sakila;

desc rental;

SELECT * FROM rental LIMIT 20;

-- rental 테이블에서 customer_id 를 그룹핑하여 조회
SELECT 
    customer_id
FROM
    rental
GROUP BY customer_id;

-- rental 테이블에서 customer_id 및 각 customer가 대여(rental)한 횟수를 카운트하여 별도의 열로 조회
SELECT 
    customer_id, count(rental_date)
FROM
    rental
GROUP BY customer_id;
-- Error Code: 1055. Expression #2 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'sakila.rental.rental_date' which is not functionally dependent on columns in GROUP BY clause;


-- rental 테이블에서 customer_id 및 각 customer가 대여(rental)한 횟수를 카운트하여 대여한 횟수를 기준으로 내림차순하여 조회
SELECT 
    customer_id, COUNT(rental_date)
FROM
    rental
GROUP BY customer_id
ORDER BY 1 ASC; 	-- default
-- ORDER BY 2 DESC; -- 2번째 컬럼을 기준으로 내림차순 정렬


-- 대여 횟수가 40번 미만인 데이터는 제외(필터링)하여 조회
SELECT 
    customer_id, COUNT(rental_date)
FROM
    rental
WHERE COUNT(rental_date) < 40
GROUP BY customer_id;

-- having으로 조건을 걸어줘야 함
SELECT 
    customer_id, COUNT(rental_date)
FROM
    rental
GROUP BY customer_id
HAVING COUNT(rental_date) > 40
ORDER BY 2 DESC;

show tables;
select * from film;
select * from film_actor;
select * from rental;





-- *** 문제 풀기 *** --


-- 문제1. film 당 출연한 배우의 수(film, film_actor)
SELECT 
   f.film_id , COUNT(f.film_id)
FROM
    film AS f
        JOIN
    film_actor AS fa ON f.film_id = fa.film_id
group by f.film_id;



-- 문제 2. film_id , title, 영화별 대여 횟수, 대여 횟수를 내림차순으로 정렬
-- 영화별 대여 횟수를 조회하고 싶을 때,
-- select film_id , title, 
SELECT 
    f.film_id, f.title, COUNT(r.rental_id) as '영화별 대여 횟수'
FROM
    rental r
        JOIN
    inventory i ON r.inventory_id = i.inventory_id
        JOIN
    film f ON i.film_id = f.film_id
GROUP BY f.film_id
ORDER BY COUNT(r.rental_id) DESC;



-- 문제3. 영화 카테고리 NAME과 각 카테고리마다 몇개의 영화가 있는지 영화 개수 출력
select * from film;
select * from film_category;
select * from category;
SELECT 
    c.name, COUNT(fc.film_id) as '카테고리 별 영화 수'
FROM
    category AS c
        JOIN
    film_category AS fc ON c.category_id = fc.category_id
GROUP BY c.category_id;



-- 문제4. payment 테이블에서 고객 아이디 당 총 금액을 얼마 썼는지 조회 (총 금액 100 이상만)
select * from payment;
SELECT 
   customer_id, SUM(amount)
FROM
    payment
GROUP BY customer_id
HAVING SUM(amount) > 100;



-- 문제5. 영화 제목별 평균 보상비용을 구하고 싶은데, 영화의 보상비용이 15~25인 데이터를 선택해야함
-- 그렇게 영화제목별 보상비용을 조회했을 때, 데이터별 조회 후 평균이 20 이상인 데이터 조회
SELECT 
    title, AVG(replacement_cost)
FROM
    film
WHERE
    replacement_cost BETWEEN 15 AND 25
GROUP BY title
HAVING AVG(replacement_cost) >= 20;



-- 문제6. country 테이블에서 country_id 및 각 나라의 맨 앞글자로 시작하는 나라를 count하여 별도의 열로 내림차순으로
-- 그러면서 count 된 나라가 5개 이상이여야지만 조회
SELECT 
    LEFT(country, 1) AS first_letter,
    COUNT(country_id) AS count_country
FROM
    country
GROUP BY first_letter
HAVING count_country >= 5
ORDER BY count_country DESC;


-- 문제7. payment 와 rental 테이블에서 rental_id 별 customer_id를 오름차순 조회
select p.rental_id , p.customer_id
from payment as p
join rental as r
on p.rental_id = r.rental_id and p.customer_id = r.customer_id
group by r.rental_id;



