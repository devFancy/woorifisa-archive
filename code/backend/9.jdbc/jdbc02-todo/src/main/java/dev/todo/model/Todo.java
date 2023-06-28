package dev.todo.model;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String title; // 할 일 제목
    private String description; // 할 일 내용
    private LocalDate dueDate; // 할 일 마감기간
    private boolean isCompleted; // 진행 여부

    public Todo(int id, String title, String description, LocalDate dueDate, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    // Builder 타입을 인수로 받는 생성자
    public Todo(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.isCompleted = builder.isCompleted;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", isCompleted=" + isCompleted +
                '}';
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // 빌더(Builder) 패턴 (객체 생성과 관련된 패턴)
    public static class Builder {
        private int id;
        private String title;
        private String description;

        private LocalDate dueDate;

        private boolean isCompleted;

        // id를 필드로 받는 생성자
        // id가 필수 필드일 경우
        public Builder(int id) {
            this.id = id;
        }

    }
}