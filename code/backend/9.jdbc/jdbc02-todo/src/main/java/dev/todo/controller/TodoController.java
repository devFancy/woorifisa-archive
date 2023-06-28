package dev.todo.controller;

import dev.todo.dao.TodoDAO;
import dev.todo.model.Todo;
import dev.todo.view.TodoView;

import java.util.List;

/* [DB] - MySQL

use testdb;

CREATE TABLE todo (
                      id INT(5) unsigned NOT NULL AUTO_INCREMENT,
                      title VARCHAR(255),
                      description VARCHAR(255),
                      due_date DATE,
                      is_completed BOOLEAN DEFAULT false,
                      PRIMARY KEY (id)
);

INSERT INTO TODO (title, description, due_date) VALUES ('숙제하기', '수학, 영어 숙제를 한다', '2022-04-05');

INSERT INTO TODO (title, description, due_date) VALUES ('조깅하기', '공원에서 1시간 동안 조깅을 한다.', '2022-05-07');

INSERT INTO TODO (title, description, due_date) VALUES ('빨래하기', '빨래를 모아서 세탁기를 돌린다.', '2022-04-04');

INSERT INTO TODO (title, description, due_date) VALUES ('피아노치기', '학원에서 피아노를 연습한다.', '2022-04-09');

INSERT INTO TODO (title, description, due_date) VALUES ('강아지 밥주기', '강아지에게 사료를 준다.', '2022-04-07');

commit;

select *
from todo;

 */
public class TodoController {
    private final TodoDAO todoDAO;
    private final TodoView todoView;

    private int affectedRows;

    public TodoController() {
        todoDAO = new TodoDAO();
        todoView = new TodoView();
    }

    // 전체 Todo 조회
    public void findAll() {
        List<Todo> todos = todoDAO.findAll();
        todoView.findAll(todos);

        if (todos != null && todos.size() != 0) {
            todoView.findAll(todos); // viewer에게 dao에서 전달된 결과를 넘겨줌
        } else {
            Exception errorObject = new Exception("Todo 데이터가 존재하지 않습니다.");
            todoView.errorPage(errorObject);
        }
    }

    public void findById(int todoId) {
        Todo todo = todoDAO.findById(todoId);
        todoView.findById(todo);
    }

    // Todo 저장
    public void saveTodo(String insertTitle, String insertDes, String insertDate) {
        affectedRows = todoDAO.saveTodoDAO(insertTitle, insertDes, insertDate);
        todoView.save();
    }

    // Todo 수정
    public void updateTodo(int todoId, String insertTitle, String insertDes, String insertDate) {
        affectedRows = todoDAO.updateTodoDAO(todoId, insertTitle, insertDes, insertDate);
        todoView.update(affectedRows);
    }

    // Todo 삭제
    public void deleteTodo(int todoId) {
        affectedRows = todoDAO.deleteTodoDAO(todoId);
        todoView.delete(affectedRows);
    }

}
