package com.overflow.todo.service;

import com.overflow.todo.data.TodoItem;

import java.util.ArrayList;
import java.util.Date;

public interface ITodoService {
    TodoItem update(TodoItem todoItem);

    TodoItem delete(TodoItem todoItem);
    TodoItem delete(int id);

    TodoItem find(int id);

    ArrayList<TodoItem> findAfter(Date dateTime);

    ArrayList<TodoItem> find(Date dateTime);

    ArrayList<TodoItem> find();
}
