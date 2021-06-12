package com.overflow.todo.data;

import java.util.Date;

public class TodoItem {
    private final int id;
    private final int userId;
    private final String title;
    private final String description;
    private final Date dateTime;

    public TodoItem(
            int id,
            int userId,
            String title,
            String description,
            Date dateTime) {

        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "";
    }
}
