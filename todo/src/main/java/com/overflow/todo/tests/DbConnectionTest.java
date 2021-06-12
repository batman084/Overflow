package com.overflow.todo.tests;

import com.overflow.todo.database.DbConnection;

public class DbConnectionTest {
    public static void run() {
        System.out.println("Running DB Connection tests...");

        // TODO: don't need to run this test all the time
        // testDatabaseCreation();
        testPopulateSampleData();
    }

    private static void testPopulateSampleData() {
        DbConnection db = DbConnection.createConnection();

        db.
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
