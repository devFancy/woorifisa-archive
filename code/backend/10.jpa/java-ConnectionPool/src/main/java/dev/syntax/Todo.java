package dev.syntax;

import java.time.LocalDate;

// 일반 DB 입출력용 클래스
public class Todo {
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;

    public Todo(int id, String title, String description, LocalDate dueDate, boolean isCompleted) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    public Todo(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.isCompleted = builder.isCompleted;
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

    @Override
    public String toString() {
        return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
                + ", isCompleted=" + isCompleted + "]";
    }


    public static class Builder {
        private int id;
        private String title;
        private String description;
        private LocalDate dueDate;
        private boolean isCompleted;

        public Builder(int id) {
            this.id = id;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder isCompleted(Boolean isCompleted) {
            this.isCompleted = isCompleted;
            return this;
        }

        public Todo build() {
            return new Todo(this);
        }
    }
}
