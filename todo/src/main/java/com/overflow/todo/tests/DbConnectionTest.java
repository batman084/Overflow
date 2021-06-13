package com.overflow.todo.tests;

import com.overflow.todo.data.TodoItem;
import com.overflow.todo.database.DbConnection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DbConnectionTest {
    private DbConnection db;

    public static void run() {
        System.out.println("Running DB Connection tests...");

        // TODO: don't need to run this test all the time
        // testDatabaseCreation();
        testPopulateSampleData();
        testFindData();
        testUpdateData();
        testRemoveData();
    }

    private static void testPopulateSampleData() {
        DbConnection db = DbConnection.createConnection();

        db.clearAll();

        TodoItem item = null;
        System.out.println("inserting item, expecting id 1");
        item = db.update(new TodoItem(0, 0, "todo 1", "todo 1 details", TodoItem.createDate(2021, 12, 20, 13, 30)));
        System.out.println("inserted item:\n" + item);

        System.out.println("inserting item, expecting id 2");
        item = db.update(new TodoItem(0, 0, "todo 2", "todo 2 details", TodoItem.createDate(2022, 12, 21, 14, 31)));
        System.out.println("inserted item:\n" + item);

        System.out.println("inserting item, expecting id 3");
        item = db.update(new TodoItem(0, 0, "todo 3", "todo 3 details", TodoItem.createDate(2023, 12, 22, 15, 32)));
        System.out.println("inserted item:\n" + item);

        System.out.println("inserting item, expecting id 4");
        item = db.update(new TodoItem(0, 10, "todo 4", "todo 4 details", TodoItem.createDate(2025, 12, 23, 16, 33)));
        System.out.println("inserted item:\n" + item);
    }

    private static void testFindData() {
        DbConnection db = DbConnection.createConnection();

        ArrayList<TodoItem> todoItems = new ArrayList<>();

        System.out.println("looking for items, expecting count 3");
        todoItems = db.findAllForUser(0);

        System.out.println("found : " + todoItems.size());
        for (TodoItem item : todoItems) {
            System.out.println("item:\n" + item);
        }

        System.out.println("looking for item with id 1");
        TodoItem todoItem = db.find(1);
        if (todoItem == null) {
            System.out.println("item not found");
        } else {
            System.out.println("found item:\n" + todoItem);
        }
    }

    private static void testUpdateData() {
        DbConnection db = DbConnection.createConnection();

        System.out.println("updating item with id 2");
        db.update(new TodoItem(2, 0, "todo 2a", "todo 2 details updated", TodoItem.createDate(2020, 11, 1, 12, 0)));
        TodoItem todoItem = db.find(2);

        if (todoItem == null) {
            System.out.println("failed to find");
        } else {
            System.out.println("updated item:\n" + todoItem);
        }
    }

    private static void testRemoveData() {
        DbConnection db = DbConnection.createConnection();

        System.out.println("Removing id 1");
        db.remove(new TodoItem(1, 0, "", "", new Date()));

        System.out.println("verifying, expecting to not find id 1");
        TodoItem todoItem = db.find(1);
        if (todoItem == null) {
            System.out.println("success");
        } else {
            System.out.println("failure, item found");
        }
    }

    private static void testDatabaseCreation() {
        DbConnection db = null;

        // create in working directory folder with a specific name
        db = DbConnection.createConnection("", "test.db");
        // create in working directory folder with a default name
        db = DbConnection.createConnection("");
        // create elsewhere with a specific name
        db = DbConnection.createConnection("c:\\sqlite\\databases", "test.db");
        // create elsewhere with a default name
        db = DbConnection.createConnection("c:\\sqlite\\databases");
    }
}
