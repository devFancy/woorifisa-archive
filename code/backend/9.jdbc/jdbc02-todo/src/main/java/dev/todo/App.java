package dev.todo;

import dev.todo.controller.TodoController;
import dev.todo.io.Console;
import dev.todo.model.Todo;

import java.time.LocalDate;


public class App {
    private static TodoController todoController = new TodoController();

    public static void main(String[] args) {
        // 1. 전체 조회
        todoController.findAll();

        // 2. id로 조회
        Console.println("조회할 id 값을 입력해 주세요.");
        int number = Console.readInt();
        todoController.findById(number);

        // 3. 저장
        while (true) {
            Console.println("테이블을 추가하실 거에요? (네 : 1 / 아니요 : 2)");
            int createYN = Console.readInt();

            if (createYN == 1) {
                // INSERT INTO TODO (title, description, due_date) VALUES ('빨래하기', '빨래를 모아서 세탁기를 돌린다.', '2022-04-04');
                Console.println("추가할 todo title를 입력해 주세요.");
                String insertTitle = Console.read();

                Console.println("추가할 todo description를 입력해 주세요.");
                String insertDes = Console.read();

                Console.println("추가할 todo due_date를 입력해 주세요.");
                String insertDate = Console.read();

                todoController.saveTodo(insertTitle, insertDes, insertDate);

                Console.println("테이블 추가(title, description, due_date)를 반복하실 건가요?(1: 계속 / 2: 그만)");
                int createRestartOrEndNumber = Console.readInt();
                if (createRestartOrEndNumber == 2)
                    break;
            } else if (createYN == 2) {
                break;
            }
        }

        // 4. 수정
        while (true) {
            Console.println("테이블을 수정하실 거에요? (네 : 1 / 아니요 : 2)");
            int updateYN = Console.readInt();

            if (updateYN == 1) {

                Console.println("수정할 todo id를 입력해 주세요.");
                int updateId = Console.readInt();

                Console.println("수정할 todo title를 입력해 주세요.");
                String updateTitle = Console.read();

                Console.println("수정할 todo description를 입력해 주세요.");
                String updateDes = Console.read();

                Console.println("수정할 todo due_date를 입력해 주세요.");
                String updateDate = Console.read();

                todoController.updateTodo(updateId, updateTitle, updateDes, updateDate);

                Console.println("테이블 수정(title, description, due_date)을 반복하실 건가요?(1: 계속 / 2: 그만)");
                int updateRestartOrEndNumber = Console.readInt();

                if (updateRestartOrEndNumber == 2)
                    break;
            } else if (updateYN == 2) {
                break;
            }
        }

        // 5. 삭제
        while (true) {
            Console.println("테이블을 삭제하실 거에요? (네 : 1 / 아니요 : 2)");
            int deleteYN = Console.readInt();

            if (deleteYN == 1) {

                Console.println("삭제할 todo id를 입력해 주세요.");
                int deleteId = Console.readInt();

                todoController.deleteTodo(deleteId);

                Console.println("테이블 삭제(title, description, due_date)을 반복하실 건가요?(1: 계속 / 2: 그만)");
                int deleteRestartOrEndNumber = Console.readInt();

                if (deleteRestartOrEndNumber == 2)
                    break;
            } else if (deleteYN == 2) {
                break;
            }
        }
    }
}
