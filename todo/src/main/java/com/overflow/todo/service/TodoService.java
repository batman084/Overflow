package com.overflow.todo.service;

import com.overflow.todo.data.TodoItem;
import com.overflow.todo.database.DbConnection;
import com.overflow.todo.database.IDbConnection;

import java.util.Date;
import java.util.ArrayList;

public class TodoService implements ITodoService {

    private final IDbConnection dbConnection;
    
    public TodoService() {
        this(null);
    }

    public TodoService(IDbConnection dbConnection) {

        if (dbConnection == null) {
            dbConnection = DbConnection.createConnection();
        }

        this.dbConnection = dbConnection;
    }

    public TodoItem update(TodoItem todoItem) {
        return null;
    }

    public TodoItem delete(TodoItem todoItem) {
        return null;
    }

    public TodoItem find(String id) {
        return null;
    }

    public ArrayList<TodoItem> findAfter(Date dateTime) {
        return null;
    }

    public ArrayList<TodoItem> find(Date dateTime) {
        return null;
    }

    public ArrayList<TodoItem> find() {
        return null;
    }
}