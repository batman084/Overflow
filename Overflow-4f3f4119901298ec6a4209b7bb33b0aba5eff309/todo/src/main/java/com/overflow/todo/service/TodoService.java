package com.overflow.todo.service;

import com.overflow.todo.data.TodoItem;
import com.overflow.todo.database.DbConnection;
import com.overflow.todo.database.IDbConnection;

import java.util.Date;
import java.util.ArrayList;

public class TodoService implements ITodoService {

    private final IDbConnection dbConnection;
    private static final int DefaultUserId = 0;

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

        return this.dbConnection.update(todoItem);
    }

    public TodoItem delete(int id) {
        return this.dbConnection.remove(id);
    }


    public TodoItem delete(TodoItem todoItem) {
        return this.dbConnection.remove(todoItem);
    }

    public TodoItem find(int id) {
        return this.dbConnection.find(id);
    }

    public ArrayList<TodoItem> findAfter(Date dateTime) {
        ArrayList<TodoItem> items = this.dbConnection.findAllForUser(DefaultUserId);
        ArrayList<TodoItem> selectedItems = new ArrayList<TodoItem>();

        for (TodoItem item : items) {
            // pick only items with date greater than 
            if (item.getDateTime().after(dateTime)) {
                selectedItems.add(item);
            }
        }

        return selectedItems;
    }

    public ArrayList<TodoItem> find(Date dateTime) {
        ArrayList<TodoItem> items = this.dbConnection.findAllForUser(DefaultUserId);
        ArrayList<TodoItem> selectedItems = new ArrayList<TodoItem>();

        for (TodoItem item : items) {
            // pick only items with the same year/month/date
            if ((item.getDateTime().getDate() == dateTime.getDate())  &&
                    (item.getDateTime().getMonth() == dateTime.getMonth()) &&
                    (item.getDateTime().getYear() == dateTime.getYear())) {
                selectedItems.add(item);
            }
        }

        return selectedItems;
    }

    public ArrayList<TodoItem> find() {
        return this.dbConnection.findAllForUser(DefaultUserId);
    }
}