package com.overflow.todo.service;

import java.util.Date;

public class TodoItem {
    private final String id;
    private final String userId;
    private final String title;
    private final String description;
    private final Date dateTime;

    public TodoItem(
            String id,
            String userId,
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
