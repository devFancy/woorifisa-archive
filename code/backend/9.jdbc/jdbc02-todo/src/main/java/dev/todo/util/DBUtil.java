package dev.todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DB와 관련된 공통 처리 코드들을 별도의 유틸 클래스로 분리
 */
public class DBUtil {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/"; // DB 서버 접근용 URL
    public static final String DATABASE_NAME = "testdb";
    public static final String USER = "root";
    public static final String PASSWORD = "1121";
    public static final String SELECT_QUERY = "SELECT id, title, description, due_date, is_completed FROM todo";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
