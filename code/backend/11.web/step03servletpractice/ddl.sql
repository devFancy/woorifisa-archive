DROP TABLE IF EXISTS mouse;

CREATE TABLE Mouse (
    id INT(5) unsigned AUTO_INCREMENT,
    name VARCHAR(50),
    country VARCHAR(50),
    address VARCHAR(50),
    PRIMARY KEY (id)
);


INSERT INTO Mouse(name, country, address)
VALUES ('미니', '하와이', '구직 중');

INSERT INTO Mouse(name, country, address)
VALUES ('미키', '런던', '맨체스터 유나이티드');

INSERT INTO Mouse(name, country, address)
VALUES ('제이', '상하이', '텐센트');

INSERT INTO Mouse(name, country, address)
VALUES ('제리', '도쿄', '라인');

INSERT INTO Mouse(name, country, address)
VALUES ('제이미', '대한민국', '삼성');


Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");