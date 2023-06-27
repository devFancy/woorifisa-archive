-- 17.isolation

DROP TABLE IF EXISTS sales;

CREATE TABLE sales (
	PRODUCT_ID INT PRIMARY KEY,
	QUANTITY INT,
	PRICE INT
);

INSERT INTO sales VALUES (1, 10, 5);
INSERT INTO sales VALUES (2, 20, 4);

-- Dirty read test

-- 격리 레벨 격하 (READ UNCOMMITTED, READ COMMITTED)
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED; -- READ UNCOMMITTED 레벨로 격하

-- 격리 레벨 격상 (READ UNCOMMITTED 에서 READ UNCOMMITTED로)
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED; -- READ COMMITTED 레벨로 격상
SET SESSION TRANSACTION ISOLATION LEVEL repeatable read; -- repeatable read 레벨로 격상
SET SESSION TRANSACTION ISOLATION LEVEL serializable; -- serializable 레벨로 격상

-- 현재 격리 레벨 확인
SELECT @@SESSION.transaction_isolation;

-- Transaction A
BEGIN;


-- 상품별 총 금액 조회
SELECT 
    PRODUCT_ID, QUANTITY * PRICE
FROM
    SALES; -- 50 & 80 이 나옴

-- cmd 창에서 중간에 UPDATE
-- UPDATE SALES SET QUANTITY = QUANTITY + 5 WHERE PRODUCT_ID = 1;

SELECT 
    SUM(QUANTITY * PRICE)
FROM
    SALES; 
-- READ UNCOMMITTED 레벨에서 조회 시, 155이 나옴
-- repeatable read 레벨에서 조회 시, 130이 나옴
    
-- cmd 에서 rollback 함
-- rollback;
    
COMMIT;
