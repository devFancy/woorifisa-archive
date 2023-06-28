-- 14. trx_basic

CREATE DATABASE engine_trx_test;

USE engine_trx_test;

-- MyISAM 스토리지엔진 기반 테이블 생성
CREATE TABLE myisam_table (
	id INT NOT NULL, PRIMARY KEY(id)
)ENGINE=MyISAM; -- default로 InnoDB가 설정됨

-- 더미데이터 삽입
INSERT INTO myisam_table (id) VALUES (3);

-- InnoDB 엔진 기반 테이블 생성
CREATE TABLE innodb_table ( id INT NOT NULL, PRIMARY KEY(id))
ENGINE=INNODB;

-- 더미데이터 삽입
INSERT INTO innodb_table (id) VALUES (3);

-- 엔진 별로 데이터 삽입했을 때 결과 확인

-- 한 번에 1, 2, 3 값을 추가
INSERT INTO myisam_table (id) VALUES (1), (2), (3);
SELECT * FROM myisam_table;

INSERT INTO innodb_table (id) VALUES (1), (2), (3);
SELECT * FROM innodb_table;
