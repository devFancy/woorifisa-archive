package dev.syntax;

import java.sql.*;

public class Step01UsingSimpleCP {

    static {
        final String URL = "jdbc:mysql://localhost:3306/testdb";
        final String USER = "root";
        final String PASSWORD = "1121";

        try {
            MyConnectionPool.create(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // 2. getConnection으로 미리 생성된 커넥션 객체를 취득
        Connection connection = MyConnectionPool.getConnection();

        // 3. DB 입출력 처리
        String sql = "SELECT * FROM todo";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery();
        ) {
            rs.next();
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            Date dueDate = rs.getDate("due_date");
            int isCompleted = rs.getInt("is_completed");

            Todo todo = new Todo(id, title, description, dueDate.toLocalDate(), isCompleted == 1);
            System.out.println(todo);

            // 4. 입출력 처리가 끝나면 별도의 메서드를 호출해서 사용한 커넥션을 커넥션 풀에 다시 반납
            MyConnectionPool.releaseConnection(connection);

            // 5. 프로그램이 종료될 때 별도의 메서드를 호출해서 모든 커넥션 객체 close() - 커넥션 풀이 담당
            MyConnectionPool.shutdown();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
