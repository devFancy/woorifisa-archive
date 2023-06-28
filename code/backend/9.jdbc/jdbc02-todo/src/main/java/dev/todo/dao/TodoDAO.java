package dev.todo.dao;


import dev.todo.model.Todo;
import dev.todo.util.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static dev.todo.util.DBUtil.*;

// DAO, Data Access Object의 줄임말
// 실제로 DB에 접속하는 역할을 수행하는 코드
// 건물 내 DB 정보에 접근해서 조회할 수 있는 직원
public class TodoDAO {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    int affectedRows;

    public List<Todo> findAll() {
        List<Todo> todos = new ArrayList<>();
        try {
            // DB와의 연결 객체 생성
            // 필요한 라이브러리 파일: Referenced Libraries/mysql-connector-j-8.0.33.jar
            connection = DBUtil.getConnection();

            statement = connection.createStatement();
            // ResultSet
            resultSet = statement.executeQuery(SELECT_QUERY);

            // 결과 데이터 출략(View)
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Date date = resultSet.getDate("due_date");
                LocalDate dueDate = date.toLocalDate();
                boolean isCompleted = resultSet.getBoolean("is_completed");

                todos.add(new Todo(id, title, description, dueDate, isCompleted));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 자원 반납, 해제(순서 -> 역순)
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        // 결과 데이터 출력(View)
        return todos;
    }

    // id에 해당하는 한 개의 Todo 데이터 조회
    public Todo findById(int todoId) {
        Todo todo = null;
        ResultSet rs = null;

        // Java7 이후 방식 try-with-resources 문법
        // try () 소괄호 내부에 작성한 JDBC 객체들은 자동으로 자원이 반납됨(close()를 사용하지 않아도 됨)
        // JDBC 객체 이외에 자원 반납이 필요한 다른 객체들도 동일하게 사용 가능
        // 조건, AutoCloseable 인터페이스를 구현한 클래스만 사용 가능

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from todo where id = ?");) {

            statement.setInt(1, todoId); // ?에 맵핑할 값을 지정, 좌측부터 물음표 개수만큼 넘버링 지정
            rs = statement.executeQuery();

            rs.next();
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            Date dueDate = rs.getDate("due_date");
            int isCompleted = rs.getInt("is_completed");

            todo = new Todo(id, title, description, dueDate.toLocalDate(), isCompleted == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {

            }
        }

        return todo;
    }

    // Todo 저장
    public int saveTodoDAO(String insertTitle, String insertDes, String insertDate) {

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO TODO (title, description, due_date) VALUES (?, ?, ?)");) {

            statement.setString(1, insertTitle);
            statement.setString(2, insertDes);
            statement.setString(3, insertDate);
            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    // Todo 수정
    public int updateTodoDAO(int todoId, String insertTitle, String insertDes, String insertDate) {

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("UPDATE TODO SET title = ?, description = ?, due_date = ? WHERE id = ?");) {

            statement.setString(1, insertTitle);
            statement.setString(2, insertDes);
            statement.setString(3, insertDate);
            statement.setInt(4, todoId);
            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    // Todo 삭제
    public int deleteTodoDAO(int todoId) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("DELETE FROM TODO WHERE id = ?");) {

            statement.setInt(1, todoId);
            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }
}
