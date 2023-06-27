-- 5-2.join

-- 범위에 따른 JOIN의 구분
-- INNER JOIN - 조인이 성공한 범위(결과 행)만 반환하는 조인
-- OUTER JOIN - 조인이 실패한 범위
-- -> 조인이 성공한 범위를 INNER JOIN, 조인이 실패한 범위를 OUTER라고 가정
SELECT a.x AS 'x of ta', a.y AS 'y of ta', a.z AS 'z of ta', b.x AS 'x of tb', b.y AS 'y of tb', b.z AS 'z of tb' 
FROM ta a 
INNER JOIN tb b 
ON b.x = a.x AND b.y = a.y;

SELECT a.x AS 'x of ta', a.y AS 'y of ta', a.z AS 'z of ta', b.x AS 'x of tb', b.y AS 'y of tb', b.z AS 'z of tb' 
FROM ta a 
INNER JOIN tb b
ON b.x = a.x AND b.y = a.y AND b.z = a.z;


-- ta가 아우터 기준일 때,
-- 테이블 a 에 값만 있으면, a 관련된 애들이 다 나오고, a에 값이 없는 애들은 안나옴
use join_test3;

SELECT
    a.x AS 'x of ta', b.x AS 'x of tb'
FROM
    ta a
        LEFT OUTER JOIN
    tb b ON b.x = a.x;