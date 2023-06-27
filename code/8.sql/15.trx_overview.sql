

-- 15. trx_overview
CREATE DATABASE trx_test;
USE trx_test;

SELECT database();

-- t1 테이블 생성
CREATE TABLE t1 (
	cd INT,
	v1 INT
);

INSERT INTO t1 VALUES (1, 50);
INSERT INTO t1 VALUES (2, 50);
COMMIT;

SELECT * FROM t1;

-- MySQL에서는 기본적으로 autocommit모드가 활성화되어 있음

-- autocommit 모드 확인
SELECT @@AUTOCOMMIT; -- 1(TRUE), 0(FALSE)

SET AUTOCOMMIT = 0; -- autocommit 비활성화
SELECT @@AUTOCOMMIT;

BEGIN; -- 트랜잭션 시작, 이 아래로 작성되는 모든 쿼리는
-- 하나의 트랜잭션 내에 포함됨(START TRANSACTION과 같음)
INSERT INTO t1 VALUES (3, 50);

SELECT trx_id, trx_state, trx_started, trx_operation_state, trx_tables_in_use, trx_tables_locked, trx_isolation_level FROM INFORMATION_SCHEMA.INNODB_TRX;

COMMIT; -- 트랜잭션 종료

SELECT trx_id, trx_state, trx_started, trx_operation_state, trx_tables_in_use, trx_tables_locked, trx_isolation_level FROM INFORMATION_SCHEMA.INNODB_TRX;

-- 현재 사용 중인 테이블의 엔진 조회
SHOW TABLE STATUS WHERE name='t1';

-- 