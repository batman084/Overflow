package com.overflow.todo.tests;

import com.overflow.todo.data.TodoItem;
import com.overflow.todo.database.DbConnection;

import java.util.Calendar;
import java.util.Date;

public class DbConnectionTest {
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
        item = db.update(new TodoItem(0, 0, "todo 1", "todo 1 details", new Date(2021, 12, 20, 13, 30, 58)));
        System.out.println("inserted item: " + item);

        item = db.update(new TodoItem(0, 0, "todo 2", "todo 2 details", new Date(2022, 12, 21, 14, 31, 59)));
        System.out.println("inserted item: " + item);

        item = db.update(new TodoItem(0, 0, "todo 3", "todo 3 details", new Date(2023, 12, 22, 15, 32, 0)));
        System.out.println("inserted item: " + item);
    }

    private static void testFindData() {
        DbConnection db = DbConnection.createConnection();
    }

    private static void testUpdateData() {
        DbConnection db = DbConnection.createConnection();
    }

    private static void testRemoveData() {
        DbConnection db = DbConnection.createConnection();
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
