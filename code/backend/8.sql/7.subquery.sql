-- 7.subquery

-- 1. customer 테이블에서 customer_id열의 최대값 조회
select max(customer_id) from customer;

-- 2. customer 테이블에서 customer_id가 최대값인 회원의 customer_id, last_name, first_name 조회
SELECT 
    customer_id, last_name, first_name
FROM
    customer
WHERE
    customer_id = 599; -- 동적으로 적용 x
    
-- 3. 서브 쿼리를 활용하여 동적으로 적용될 수 있도록(customer_id 가 최대값인 회원)
-- customer_id가 최대값 -> 신규 가입자
SELECT 
    customer_id, last_name, first_name
FROM
    customer
WHERE
    customer_id = (SELECT 
            MAX(customer_id)
        FROM
            customer); -- 기존 2.쿼리문에 1.쿼리문을 넣어주자
-- 왼쪽에 있는 customer_id항과 오른쪽의 항의 잘 맞춰주기!~


-- --------------------------------------------------------------- --

-- 문제
-- city 테이블 상위 10개 조회
select * from city limit 10;

-- country 테이블 상위 10개 조회
select * from country limit 10;

-- city 테이블에서 한국(South Korea)에 해당되는 모든 도시 조회
SELECT 
    city_id, city
FROM
    city
WHERE
    country_id = (SELECT 
            country_id
        FROM
            country
        WHERE
            country = 'South Korea');


-- country 테이블에서 인도(’India’)가 아닌 국가의 모든 열 조회
select * from country where country != 'India';

-- city 테이블에서 인도를 제외한 모든 국가(country)의 city_id, city를 조회
SELECT 
    city_id, city
FROM
    city
WHERE
    country_id != (SELECT 
            country_id
        FROM
            country
        WHERE
            country = 'India');


-- IN 을 사용할 수 있다.
-- 특정 집합에 속하는지 확인할 때 사용하는 연산자
SELECT 
    city_id, city
FROM
    city
WHERE
    country_id IN (SELECT 
            country_id
        FROM
            country
        WHERE
            country != 'India');
            
            
-- City 테이블에서 country가 canada이거나 mexico에 속하는 모든 city_id, city를 조회
SELECT 
    city_id, city
FROM
    city
WHERE
    country_id IN (SELECT 
            country_id
        FROM
            country
        WHERE
            country = 'canada' OR country = 'mexico');


-- City 테이블에서 country가 canada이거나 mexico에 속하지 않는 모든 city_id, city를 조회
SELECT 
    city_id, city
FROM
    city
WHERE
    country_id not IN (SELECT 
            country_id
        FROM
            country
        WHERE
            country = 'canada' OR country = 'mexico');
