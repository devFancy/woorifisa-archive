package org.example.syntex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App2 {
    public static void main(String[] args) throws ClassNotFoundException {

        // Java 프로그램과 DB 서버와 연결하는 작업

        // 1. DB와 연결 시 필요한 정보 작성
        final String DB_URL = "jdbc:mysql://localhost:3306/";   // DB 서버 접근용 URL
        final String DATABASE_NAME = "testdb";  // 접속할 DB 이름
        final String USER = "root"; // 접속하는 사용자 계정
        final String PASSWORD = "1121";

        // JDBC 4.0 이후로 모든 드라이버들은 Class Path에서 자동으로 로딩됨
        final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; // 드라이버 이름

        // 2. DB 연결 코드 작성
        try {
            // JDBC 4.0 이전 방식
            Class.forName(DRIVER_NAME); // 드라이버 로딩

            Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);

            // 쿼리 수행
            Statement statement = connection.createStatement(); // 쿼리문 전달해주는 역할 ex) 배송 트럭

            final String createTableQuery =
                    "CREATE TABLE todo (" +
                            "id INT(5) unsigned NOT NULL AUTO_INCREMENT," +
                            "title VARCHAR(255)," +
                            "description VARCHAR(255)," +
                            "due_date DATE," +
                            "is_completed BOOLEAN DEFAULT false," +
                            "PRIMARY KEY (id))";
            statement.execute(createTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
