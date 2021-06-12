package com.overflow.todo.database;

import com.overflow.todo.data.TodoItem;

import java.sql.*;

public class DbConnection implements IDbConnection{
    private static final String DefaultDatabaseName = "overflow.db";
    private final String databaseDirectory;
    private final String databaseName;
    private final String databaseUrl;

    private DbConnection(String databaseDirectory, String databaseName) {
        this.databaseDirectory = databaseDirectory;
        this.databaseName = databaseName;
        this.databaseUrl = "jdbc:sqlite:" + this.databaseDirectory + "/" + databaseName;
    }

    public static DbConnection createConnection() {
        return createConnection(createDefaultPath());
    }

    public static DbConnection createConnection(String databaseDirectory) {
        return createConnection(databaseDirectory, DefaultDatabaseName);
    }

    public static DbConnection createConnection(String databaseDirectory, String databaseName) {
        if ((databaseDirectory == null) || databaseDirectory.isEmpty()) {
            databaseDirectory = createDefaultPath();
        }

        if ((databaseName == null) || databaseName.isEmpty()) {
            databaseName = DefaultDatabaseName;
        }
        // clean up path
        databaseDirectory = databaseDirectory.replace("\\", "/");

        DbConnection dbConnection = new DbConnection(databaseDirectory, databaseName);
        // configure database
        dbConnection.createDatabase();

        return dbConnection;
    }

    private void createDatabase() {
        createDatabase(this.databaseUrl);
    }

    private void createDatabase(String databaseUrl) {
        try (Connection conn = DriverManager.getConnection(databaseUrl)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTodoTable() {
        createTodoTable(this.databaseUrl);
    }

    private void createTodoTable(String databaseUrl) {
        String sql = "CREATE TABLE IF NOT EXISTS todoItems (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	userId integer,\n"
                + "	title text NOT NULL,\n"
                + "	description text NOT NULL,\n"
                + "	date text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(databaseUrl);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String createDefaultPath() {
        return System.getProperty("user.dir");
    }

    @Override
    public TodoItem update(TodoItem item) {
        return null;
    }

    @Override
    public TodoItem remove(TodoItem item) {
        return null;
    }
    @Override
    public TodoItem find(int id) {
        return null;
    }

    @Override
    public TodoItem[] findAllForUser(int userId) {
        return null;
    }

    @Override
    public void clearAll() {

    }
}