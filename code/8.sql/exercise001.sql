use testdb;

show tables;

-- apple store  
CREATE TABLE apple_store (
    product_id INT(5) UNSIGNED NOT NULL AUTO_INCREMENT, -- AUTO_INCREMENT : mysql에만 있음 / oracle은 sequence
    category VARCHAR(20),
    price INT(20),
    color VARCHAR(20),
    release_date DATE,
    PRIMARY KEY (product_id)
);

-- apple_store insert
INSERT INTO apple_store (category, price, color, release_date) VALUES ('아이폰', 1500000, '실버','2022-04-07');
INSERT INTO apple_store (category, price, color, release_date) VALUES ('맥북', 3000000, '스페이스그레이','2023-05-15');
INSERT INTO apple_store (category, price, color, release_date) VALUES ('비전프로', 5000000, '블랙','2024-01-01');

SELECT * FROM apple_store;