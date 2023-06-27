-- range partition

# 파티션 내부 처리 학습용 샘플 테이블 복사
CREATE TABLE test_rental LIKE sakila.rental;

# 기본키 변경
ALTER TABLE test_rental
DROP PRIMARY KEY,
ADD PRIMARY KEY (rental_id, rental_date);

# 파티션 구조 추가
ALTER TABLE test_rental
PARTITION BY RANGE ( YEAR(rental_date) ) (
 PARTITION p1 VALUES LESS THAN (2006),
 PARTITION p2 VALUES LESS THAN (2007)
);

# 데이터 삽입
INSERT INTO test_rental SELECT * FROM sakila.rental;

# 개별 파티션 확인
SELECT table_name, partition_name
FROM INFORMATION_SCHEMA.PARTITIONS
WHERE TABLE_SCHEMA = 'partition_test'
  AND TABLE_NAME = 'test_rental';

# p2 파티션만 조회
SELECT count(*) FROM test_rental PARTITION (p2);

# p1 파티션에 2006년에 해당하는 데이터가 있는지 확인하는 쿼리
SELECT *
FROM test_rental PARTITION (p1)
WHERE YEAR(rental_date) = 2006;

# p2 파티션에 2005년에 해당하는 데이터가 있는지 확인하는 쿼리
SELECT * FROM test_rental PARTITION (p2) WHERE YEAR(rental_date) = 2005;

# 기존에 사용하던 파티션 제거
ALTER TABLE test_rental REMOVE PARTITIONING;

# 연월 기준으로 파티셔닝
ALTER TABLE test_rental
PARTITION BY RANGE (YEAR(rental_date)*100+MONTH(rental_date)) (
  PARTITION p1 VALUES LESS THAN (200506),
  PARTITION p2 VALUES LESS THAN (200507),
  PARTITION p3 VALUES LESS THAN (200508),
  PARTITION p4 VALUES LESS THAN (200509),
  PARTITION p5 VALUES LESS THAN (MAXVALUE)
);