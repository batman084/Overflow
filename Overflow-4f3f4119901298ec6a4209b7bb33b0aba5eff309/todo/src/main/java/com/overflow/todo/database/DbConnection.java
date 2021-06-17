package com.overflow.todo.database;

import com.overflow.todo.data.TodoItem;
/*import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteOpenMode;*/

import java.sql.*;
import java.util.ArrayList;

public class DbConnection implements IDbConnection {
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
        dbConnection.createDatabaseIfNotExst();

        return dbConnection;
    }

    private void createDatabaseIfNotExst() {
        createDatabaseIfNotExst(this.databaseUrl);
    }

    private void createDatabaseIfNotExst(String databaseUrl) {

        if (new java.io.File(databaseUrl).exists()) {
            return;
        }

        try {
            Connection connection = createSqlLiteConnection(databaseUrl, true);

            if (connection != null) {

                DatabaseMetaData meta = connection.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created: " + databaseUrl);
            }

            createTodoTable(databaseUrl);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void createTodoTable() {
        createTodoTable(this.databaseUrl);
    }

    private Connection createSqlLiteConnection(String databaseUrl) {
        return createSqlLiteConnection(databaseUrl, false);
    }

    private Connection createSqlLiteConnection(String databaseUrl, boolean shouldCreate) {

        Connection connection = null;
        try {
            // SQLiteConfig config = new SQLiteConfig();
            // config.resetOpenMode(shouldCreate ? SQLiteOpenMode.CREATE : SQLiteOpenMode.EXCLUSIVE);

            // connection = DriverManager.getConnection(databaseUrl, config.toProperties());
            connection = DriverManager.getConnection(databaseUrl);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return connection;
    }

    private void createTodoTable(String databaseUrl) {
        String sql = "CREATE TABLE IF NOT EXISTS todoItems (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	userId integer,\n"
                + "	title text NOT NULL,\n"
                + "	description text NOT NULL,\n"
                + "	datestr text NOT NULL\n"
                + ");";

        try {
            Connection connection = createSqlLiteConnection(databaseUrl);
            Statement statement = connection.createStatement();
            // create a new table
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void deleteTodoTable() {
        deleteTodoTable(this.databaseUrl);
    }

    private void deleteTodoTable(String databaseUrl) {
        String sql = "DROP TABLE IF EXISTS todoItems";

        try {
            Connection connection = createSqlLiteConnection(databaseUrl);
            Statement statement = connection.createStatement();
            // delete table
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    private int insert(
            int userId,
            String title,
            String description,
            String dateTimeString) {

        String sql = "INSERT INTO todoItems(userId, title, description, datestr) VALUES(?, ?, ?, ?)";
        int id = 0;

        try {
            Connection connection = createSqlLiteConnection(databaseUrl);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setString(4, dateTimeString);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating To Do item failed, no rows affected.");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating To Do item failed, no ID obtained.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return id;
    }

    private void update(
            int id,
            int userId,
            String title,
            String description,
            String dateTimeString) {

        String sql = "UPDATE todoItems SET userId=?, title=?, description=?, datestr=? WHERE id=?";

        try {
            Connection connection = createSqlLiteConnection(databaseUrl);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setString(4, dateTimeString);
            statement.setInt(5, id);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating To Do item failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void delete(int id) {

        String sql = "DELETE FROM todoItems WHERE id=?";

        try {
            Connection connection = createSqlLiteConnection(databaseUrl);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("delete To Do item failed, no rows affected.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private ArrayList<TodoItem> findItemsById(int id) {

        ArrayList<TodoItem> todoItems = new ArrayList<TodoItem>();
        String sql = "SELECT * FROM todoItems WHERE id=?";

        try {
            Connection connection = createSqlLiteConnection(databaseUrl);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            todoItems = getItems(resultSet);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return todoItems;
    }

    private ArrayList<TodoItem> findItemsByUserId(int userId) {
        ArrayList<TodoItem> todoItems = new ArrayList<TodoItem>();
        String sql = "SELECT * FROM todoItems WHERE userId=?";

        try {
            Connection connection = createSqlLiteConnection(databaseUrl);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            todoItems = getItems(resultSet);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return todoItems;
    }

    private ArrayList<TodoItem> getItems(ResultSet resultSet) {
        ArrayList<TodoItem> todoItems = new ArrayList<TodoItem>();

        try {
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("userId");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String dateTimeString = resultSet.getString("datestr");

                TodoItem todoItem = new TodoItem(id, userId, title, description, dateTimeString);
                todoItems.add(todoItem);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return todoItems;
    }

    private static String createDefaultPath() {
        return System.getProperty("user.dir");
    }

    @Override
    public TodoItem update(TodoItem item) {

        if (item.getId() == 0) {
            // it's a new item, insert it
            int id = insert(item.getUserId(), item.getTitle(), item.getDescription(), item.getDateTimeString());
            item = new TodoItem(id, item.getUserId(), item.getTitle(), item.getDescription(), item.getDateTime());
        } else {
            // it's an existing item, update it
            update(item.getId(), item.getUserId(), item.getTitle(), item.getDescription(), item.getDateTimeString());
        }

        return item;
    }

    @Override
    public TodoItem remove(int id) {

        TodoItem item = find(id);
        delete(id);
        return item;
    }

    @Override
    public TodoItem remove(TodoItem item) {

        delete(item.getId());
        return item;
    }

    @Override
    public TodoItem find(int id) {

        ArrayList<TodoItem> items = findItemsById(id);

        TodoItem item = null;

        if (items.size() > 0) {
            item = items.get(0);
        }

        return item;
    }

    @Override
    public ArrayList<TodoItem> findAllForUser(int userId) {
        ArrayList<TodoItem> items = findItemsByUserId(userId);
        return items;
    }

    @Override
    public void clearAll() {
        deleteTodoTable();
        createTodoTable();
    }
}