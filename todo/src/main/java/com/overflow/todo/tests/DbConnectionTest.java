package com.overflow.todo.tests;

import com.overflow.todo.database.DbConnection;

public class DbConnectionTest {
    public static void run() {
        System.out.println("Running DB Connection tests...");

        DbConnection db = new DbConnection();
        db.createDatabase("test.db");
    }
}
