DROP TABLE IF EXISTS coffee;


CREATE TABLE coffee (
    id INT(5) unsigned AUTO_INCREMENT,
    name VARCHAR(50),
    size VARCHAR(20),
    price INT,
    PRIMARY KEY (id)
);

INSERT INTO coffee(name, size, price)
VALUES ('아메리카노', 'tall', '5000');

INSERT INTO coffee(name, size, price)
VALUES ('페퍼민트', 'grande', '4000');

INSERT INTO coffee(name, size, price)
VALUES ('카페라떼', 'tall', '4500');