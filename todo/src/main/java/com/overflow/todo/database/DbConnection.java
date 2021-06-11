package com.overflow.todo.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String DefaultDatabasePath = "overflow.db";

    public void createDatabase() {
        createDatabase(DefaultDatabasePath);
    }
    
    public void createDatabase(String fileName) {
        String url = "jdbc:sqlite:C:/sqlite/databases/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}