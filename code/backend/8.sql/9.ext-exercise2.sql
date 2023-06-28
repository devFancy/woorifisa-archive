-- 9.ext-exercise2

-- 1. actor 테이블에서 first_name과 last_name을 연결하여(concat) 대문자(upper)로 출력되도록 쿼리 작성
select * from actor;
SELECT 
    CONCAT(UPPER(first_name), UPPER(last_name))
FROM
    actor;


-- 2. actor 테이블에서 actor_id, first_name, last_name을 조회하되, first_name이 Joe인 사람을 조회
-- 제약조건: 테이블 내 실제 값은 대문자인 JOE로 되어있지만, 'Joe'와 같이 대문자 외에 소문자로 섞어서 조회해도 조회가 가능하도록 쿼리 작성
select * from actor;
SELECT 
    actor_id, first_name, last_name
FROM
    actor
WHERE
    first_name IN ('Joe' , 'JOE', 'joe');


-- 3. actor 테이블에서 last_name과 총 몇 명이 동일한 last_name을 가지고 있는지 조회

/*
`그룹핑 기준`
last_name

`정렬 기준`
1. actor_count 내림차순
2. last_name 오름차순
*/
select * from actor;
SELECT 
    last_name, COUNT(last_name)
FROM
    actor
GROUP BY last_name
ORDER BY last_name ASC; -- ??


-- 4. 3번 문제 내용으로 동일하게 조회하되, 그룹핑 조건으로 actor_count가 3보다 큰 데이터만 조회
SELECT 
    last_name, COUNT(last_name)
FROM
    actor
GROUP BY last_name
ORDER BY last_name ASC; -- ??


-- 5. address 테이블에 대한 테이블 생성 쿼리를 조회하기 위한 쿼리 작성
-- hint. `SHOW`  키워드
-- → address 테이블 생성 시 사용된 DDL 쿼리를 조회할 수 있음
show create table address;


-- 6. JOIN을 활용하여 staff의 first_name과 last_name, address, district, postal_code, city_id를 조회
select * from staff;
select * from address;
show tables;
SELECT 
    first_name,
    last_name,
    address,
    district,
    postal_code,
    city_id
FROM
    staff AS s
        JOIN
    address AS a ON s.address_id = a.address_id;



-- → 조인하는 테이블 간 공통되지 않는 컬럼은 별칭을 작성하지 않아도, 참조 가능(first_name, last_name 등)
-- address_id는 두 테이블에 모두 존재하기 때문에 각각 별칭 지정 필요


-- 7. JOIN을 활용하여 각 staff가 2005년 8월에 집계한 총 금액, first_name, last_name 조회
select * from staff;
select * from payment;

SELECT 
    s.first_name, s.last_name, sum(p.amount)
FROM
    staff AS s
        JOIN
    payment AS p ON s.staff_id = p.staff_id
where payment_date BETWEEN '2005-08-01' AND '2005-09-01'
GROUP BY s.staff_id;
-- 각 staff를 group 으로 묶어줘야 함!!
-- 1개의 그룹 - 1개 ..



-- 8. 영화 제목과 해당 영화에 등장한 배우의 총 인원 수를 조회(INNER JOIN  활용)
show tables;


-- 9. 영화 제목이 'Hunchback Impossible'인 영화는 inventory 테이블에 총 몇 개의 복제본이 있는지 조회
-- ex) 만약, Inventory 테이블에 A라는 영화의 복제본이 5개일 경우, 5개의 비디오를 대여 가능하다는 의미
select * from film where title = 'Hunchback Impossible';
select * from inventory;

SELECT 
    film_id, COUNT(film_id)
FROM
    inventory
WHERE
    film_id = (SELECT 
            film_id
        FROM
            film
        WHERE
            title = 'Hunchback Impossible')
GROUP BY film_id;


-- 10. 고객의 first_name, last_name과 각 고객(customer)이 지금까지 대여 과정에서 지불한 총 금액을 조회
select * from customer;
select * from payment;
SELECT 
    first_name, last_name, SUM(p.amount)
FROM
    customer AS c
        JOIN
    payment AS p ON c.customer_id = p.customer_id
group by c.customer_id;



-- 11. 제목이 'K'나 'Q'로 시작하고, 지원 언어가 English인 모든 영화 제목 조회(서브쿼리 활용)
select * from film;
select * from language;
show tables;

SELECT 
    title
FROM
    film
WHERE
    title = ('K%' OR 'Q%')
        AND language_id = (SELECT 
            language_id
        FROM
            language
        WHERE
            name = 'English');


-- 12. `'Alone Trip'`에 등장하는 모든 영화 배우들의 first_name, last_name 조회(서브쿼리 활용)
select * from film_actor;
select * from film;
select * from actor;

select film_id
from film
where title = 'Alone Trip';

select *
from film_actor
where film_id = 17;

SELECT 
    first_name, last_name
FROM
    actor a
        JOIN
    film_actor AS fa ON a.actor_id = fa.actor_id -- film에 출연한 actor를 특정
        JOIN
    film f ON fa.film_id = f.film_id -- film을 특정지어주기
WHERE
    title = 'Alone Trip'
GROUP BY first_name , last_name; -- 중복 제거를 위해



-- 13. 국적이 캐나다인 고객의 first_name과 last_name, email 조회
select * from customer;
select * from address;
select * from city;
select * from country;
show tables;

SELECT 
    c.first_name, c.last_name, c.email
FROM
    customer AS c
        JOIN
    address AS a ON c.address_id = a.address_id
        JOIN
    city AS ci ON a.city_id = ci.city_id
        JOIN
    country AS cou ON ci.country_id = cou.country_id
WHERE
    country = 'Canada'
GROUP BY c.customer_id;



-- 14. 영화 카테고리가 가족(`'Family'`)으로 분류된 모든 영화의 제목과 출시연도 조회
select * from film;
select * from film_category;
select * from category;
show tables;

SELECT 
    title, release_year
FROM
    film_category AS fc
        JOIN
    category AS cate ON fc.category_id = cate.category_id
        JOIN
    film AS f ON f.film_id = fc.film_id
WHERE
    name = 'Family';