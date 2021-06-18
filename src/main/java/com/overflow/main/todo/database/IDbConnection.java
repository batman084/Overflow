package com.overflow.main.todo.database;

import com.overflow.main.todo.data.TodoItem;

import java.util.ArrayList;

public interface IDbConnection {
    TodoItem update(TodoItem item);

    TodoItem remove(int id);

    TodoItem remove(TodoItem item);

    TodoItem find(int id);

    ArrayList<TodoItem> findAllForUser(int userId);

    void clearAll();
}
