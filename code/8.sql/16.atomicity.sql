-- 16.atomicity
CREATE TABLE account (
	account_id INT PRIMARY KEY,
	balance int
);

INSERT INTO account(account_id, balance) VALUES (1, 10000);
INSERT INTO account(account_id, balance) VALUES (2, 20000);

BEGIN;


SELECT 
    balance
FROM
    account
WHERE
    account_id = 1;


UPDATE account 
SET 
    balance = balance - 2000
WHERE
    account_id = 1;
    
-- 데이터베이스가 다운 됨

rollback; -- 값을 원래대로 되돌릴 수 있음

SELECT * FROM account;