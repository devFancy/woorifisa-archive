-- 5.join

-- customer 테이블 정보 조회
DESC customer;
SELECT * FROM customer;

-- address 테이블 정보 조회
DESC address;
SELECT * FROM address;

SELECT 
    c.first_name, c.last_name, a.address -- a.address : address 테이블에 있는 address값을 의미
FROM
    customer AS c
        JOIN
    address AS a
LIMIT 5;
-- customer 와 address의 테이블을 join

-- 과거에 사용하던 방식
SELECT c.first_name, c.last_name, a.address 
FROM customer c, address a 
WHERE c.address_id = a.address_id;


-- 표준 문법(ANSI)
SELECT 
    c.first_name, c.last_name, a.address
FROM
    customer c
        JOIN
    address a ON c.address_id = a.address_id -- on절 : join 조건을 기술하는 부분
WHERE
    a.postal_code = 52137; -- where절 : 일반 조건을 기술하는 부분





