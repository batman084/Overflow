package com.overflow.todo.database;

import com.overflow.todo.data.TodoItem;

public interface IDbConnection {
    TodoItem update(TodoItem item);

    TodoItem remove(TodoItem item);

    TodoItem find(int id);

    TodoItem[] findAllForUser(int userId);

    void clearAll();
}
